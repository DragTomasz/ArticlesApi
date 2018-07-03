package pl.dragdrop.articles.controller;

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
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/{country}/{category}")
    public News getNewsByCountryAndCategory(@PathVariable("country") String country, @PathVariable("category") String category) {
        return newsService.getNews(country, category);
    }
}
