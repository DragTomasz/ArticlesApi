package pl.dragdrop.articles.newsapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsResponse {

    private String status;
    private Integer totalResults;
    private List<ArticleResponse> articles;
}
