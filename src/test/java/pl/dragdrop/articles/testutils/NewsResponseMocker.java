package pl.dragdrop.articles.testutils;

import pl.dragdrop.articles.newsapi.dto.ArticleResponse;
import pl.dragdrop.articles.newsapi.dto.NewsResponse;

import java.util.ArrayList;
import java.util.List;

public class NewsResponseMocker extends StaticData{

    public static NewsResponse getNewsResponse() {
        return NewsResponse
                .builder()
                .totalResults(TOTAL_RESULTS)
                .status(STATUS)
                .articles(getArticleResponses())
                .build();
    }

    private static List<ArticleResponse> getArticleResponses() {
        List<ArticleResponse> articleResponse = new ArrayList<>();
        articleResponse.add(getArticleResponse());
        articleResponse.add(getArticleResponse());
        articleResponse.add(getArticleResponse());
        return articleResponse;
    }

    private static ArticleResponse getArticleResponse() {
        return ArticleResponse.builder()
                .sourceName(SOURCE_NAME)
                .author(AUTHOR)
                .title(TITLE)
                .description(DESCRIPTION)
                .url(URL)
                .urlToImage(URL_TO_IMAGE)
                .publishedAt(PUBLISHED_AT)
                .build();
    }
}
