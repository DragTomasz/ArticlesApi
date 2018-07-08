package pl.dragdrop.articles.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class News {

    @ApiModelProperty( value = "kraj", position = 1)
    private String country;

    @ApiModelProperty(value = "kategoria", position = 2)
    private String category;

    @ApiModelProperty(value = "lista artykułów", position = 3)
    private List<Article> articles;
}
