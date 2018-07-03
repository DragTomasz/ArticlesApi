package pl.dragdrop.articles.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.dragdrop.articles.dto.News;
import pl.dragdrop.articles.service.NewsService;

@Controller
@RequestMapping("news")
@CrossOrigin
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/{country}/{category}")
    public ResponseEntity<News> getNewsByCountryAndCategory(@PathVariable("country") String country, @PathVariable("category") String category) {
        News news = newsService.getNews(country, category);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
