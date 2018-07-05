package pl.dragdrop.articles.testutils;

import pl.dragdrop.articles.dto.Article;
import pl.dragdrop.articles.dto.News;

import java.util.ArrayList;
import java.util.List;

public class NewsMocker extends StaticData {

    public static News getNews(final String country, final String category) {
        return News
                .builder()
                .country(country)
                .category(category)
                .articles(getArticles())
                .build();
    }

    private static List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(getArticle());
        articles.add(getArticle());
        articles.add(getArticle());
        return articles;
    }

    private static Article getArticle() {
        return Article.builder()
                .sourceName(SOURCE_NAME)
                .author(AUTHOR)
                .title(TITLE)
                .description(DESCRIPTION)
                .articleUrl(URL)
                .imageUrl(URL_TO_IMAGE)
                .date(PUBLISHED_AT)
                .build();
    }
}
