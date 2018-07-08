package pl.dragdrop.articles.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
public class Article {

    @ApiModelProperty(value = "autor", position = 1)
    private String author;

    @ApiModelProperty(value = "tytuł", position = 2)
    private String title;

    @ApiModelProperty(value = "opis", position = 3)
    private String description;

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "data", position = 4)
    private Date date;

    @ApiModelProperty(value = "nazwa portalu", position = 5)
    private String sourceName;

    @ApiModelProperty(value = "adres do artykułu", position = 6)
    private String articleUrl;

    @ApiModelProperty(value = "adres do obrazka", position = 7)
    private String imageUrl;
}
