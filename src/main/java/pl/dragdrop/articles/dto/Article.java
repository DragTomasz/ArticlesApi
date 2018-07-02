package pl.dragdrop.articles.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
public class Article {

    private String author;
    private String title;
    private String description;
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;
}
