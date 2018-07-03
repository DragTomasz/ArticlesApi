package pl.dragdrop.articles.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import pl.dragdrop.articles.dto.Article;
import pl.dragdrop.articles.dto.News;
import pl.dragdrop.articles.newsapi.dto.ArticleResponse;
import pl.dragdrop.articles.newsapi.dto.NewsResponse;
import pl.dragdrop.articles.newsapi.NewsApiService;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private final NewsApiService newsApiService;

    public News getNews(final String country, final String category) {
        try {
            return mapNews(newsApiService.getNews(country, category), country, category);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private News mapNews(NewsResponse newsResponse, String country, String category) {
        return News.builder()
                .category(category)
                .country(country)
                .articles(mapArticles(newsResponse.getArticles()))
                .build();
    }

    private List<Article> mapArticles(List<ArticleResponse> articlesResp) {
        return articlesResp.stream().map(this::mapArticle).collect(Collectors.toList());
    }

    private Article mapArticle(ArticleResponse artResp) {
        return Article.builder()
                .author(artResp.getAuthor())
                .title(artResp.getTitle())
                .description(artResp.getDescription())
                .date(artResp.getPublishedAt())
                .sourceName(artResp.getSourceName())
                .articleUrl(artResp.getUrl())
                .imageUrl(artResp.getUrlToImage())
                .build();
    }

}