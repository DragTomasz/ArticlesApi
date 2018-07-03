package pl.dragdrop.articles.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class News {

    private String country;
    private String category;
    private List<Article> articles;
}
