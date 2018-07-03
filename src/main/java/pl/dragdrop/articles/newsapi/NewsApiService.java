package pl.dragdrop.articles.newsapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Optional;

import lombok.AllArgsConstructor;

import okhttp3.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import pl.dragdrop.articles.exception.FailedDependencyException;
import pl.dragdrop.articles.newsapi.dto.NewsResponse;

import retrofit2.Call;
import retrofit2.Response;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Service
@AllArgsConstructor
public class NewsApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final NewsApiEndpoint newsApiEndpoint;

    public NewsResponse getNews(final String country, final String category) throws IOException {
        Call<NewsResponse> newsCall = newsApiEndpoint.getNews(country, category);

        LOGGER.info(String.format("Sending request to: %s", newsCall.request().url().toString()));

        Response<NewsResponse> newsResponse = newsCall.execute();
        if (!newsResponse.isSuccessful()) {
            String message = parseErrorResponse(newsResponse);
            throw new FailedDependencyException(message);
        }
        return newsResponse.body();
    }

    private String parseErrorResponse(Response<NewsResponse> newsResponse) throws IOException {
        Optional<ResponseBody> errorBody = Optional.ofNullable(newsResponse.errorBody());
        JsonNode productNode = new ObjectMapper().readTree(errorBody.isPresent() ? errorBody.get().string() : EMPTY);
        return productNode.get("message").asText();
    }
}
