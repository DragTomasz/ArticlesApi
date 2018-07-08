package pl.dragdrop.articles.newsapi;

import pl.dragdrop.articles.newsapi.dto.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiEndpoint {

    @GET("v2/top-headlines")
    Call<NewsResponse> getNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("page") Integer page,
            @Query("pageSize") Integer pageSize,
            @Query("q") String phrase
    );
}
