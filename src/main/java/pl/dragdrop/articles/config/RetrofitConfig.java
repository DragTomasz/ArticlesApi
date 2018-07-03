package pl.dragdrop.articles.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import pl.dragdrop.articles.newsapi.NewsApiEndpoint;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${url.news.api.domain}")
    private String baseURL;

    @Value("${url.news.api.key}")
    private String apiKey;

    @Bean
    public Retrofit newsApiRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new NewsApiAuth(apiKey))
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Bean
    public NewsApiEndpoint newsApiEndpoint(Retrofit newsApiRetrofit) {
        return newsApiRetrofit.create(NewsApiEndpoint.class);
    }

    @AllArgsConstructor
    private class NewsApiAuth implements Interceptor {

        private final String apiKey;

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder ongoing = chain.request().newBuilder();
            ongoing.addHeader("Authorization", apiKey);
            return chain.proceed(ongoing.build());
        }
    }
}
