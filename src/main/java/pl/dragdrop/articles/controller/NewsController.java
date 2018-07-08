package pl.dragdrop.articles.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.dragdrop.articles.dto.News;
import pl.dragdrop.articles.service.NewsService;

@CrossOrigin
@RestController
@RequestMapping("news")
@AllArgsConstructor
@Api(tags={"Operations available in: "})
public class NewsController {

    private final NewsService newsService;

    @ApiOperation(value = "get news with article list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved news element with article list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 424, message = "The resource is unavailable because the requested action was dependent on another action and that action failed."),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @GetMapping("/{country}/{category}")
    public News getNewsByCountryAndCategory(@ApiParam(value = "country of searched news", required = true) @PathVariable("country") String country,
                                            @ApiParam(value = "category of searched news", required = true) @PathVariable("category") String category) {
        return newsService.getNews(country, category);
    }
}
