package pl.dragdrop.articles.newsapi.dto;

import java.util.List;

import lombok.Data;

@Data
public class NewsResponse {

    private String status;
    private Integer totalResults;
    private List<ArticleResponse> articles;
}
