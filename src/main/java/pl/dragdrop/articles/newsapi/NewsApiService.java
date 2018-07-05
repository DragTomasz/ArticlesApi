package pl.dragdrop.articles.newsapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import okhttp3.ResponseBody;

import org.springframework.stereotype.Service;

import pl.dragdrop.articles.exception.FailedDependencyException;
import pl.dragdrop.articles.newsapi.dto.NewsResponse;
import pl.dragdrop.articles.newsapi.dto.Pagination;

import retrofit2.Call;
import retrofit2.Response;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Service
@Slf4j
@AllArgsConstructor
public class NewsApiService {

    private final NewsApiEndpoint newsApiEndpoint;

    public NewsResponse getNews(final String country, final String category) throws IOException {

        Call<NewsResponse> newsCall = newsApiEndpoint.getNews(country, category, Pagination.pageIndex, Pagination.pageSize);

        log.info(String.format("Sending request to: %s", newsCall.request().url().toString()));

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
