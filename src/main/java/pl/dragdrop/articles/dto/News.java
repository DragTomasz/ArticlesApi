package pl.dragdrop.articles.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class News {

    @ApiModelProperty(value = "country", position = 1)
    private String country;

    @ApiModelProperty(value = "category", position = 2)
    private String category;

    @ApiModelProperty(value = "articles", position = 3)
    private List<Article> articles;
}
