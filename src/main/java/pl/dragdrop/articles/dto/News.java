package pl.dragdrop.articles.dto;

import java.util.List;

import lombok.Data;

@Data
public class News {

    private String country;
    private String category;
    private List<Article> articles;
}
