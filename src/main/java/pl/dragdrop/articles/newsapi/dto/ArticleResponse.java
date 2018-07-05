package pl.dragdrop.articles.newsapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {

    private String sourceName;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;

    @SuppressWarnings("unchecked")
    @JsonProperty("source")
    private void unpackSource(Map<String, Object> source) {
        sourceName = (String) source.get("name");
    }
}
