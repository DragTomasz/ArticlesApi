package pl.dragdrop.articles.service;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import pl.dragdrop.articles.dto.News;
import pl.dragdrop.articles.exception.FailedDependencyException;
import pl.dragdrop.articles.newsapi.NewsApiService;
import pl.dragdrop.articles.testutils.NewsMocker;
import pl.dragdrop.articles.testutils.NewsResponseMocker;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {

    private final String COUNTRY = "pl";
    private final String CATEGORY = "technology";

    @InjectMocks
    private NewsService newsService;

    @Mock
    private NewsApiService newsApiService;

    @Before
    public void init() {
        initMocks(this);
        newsService = new NewsService(newsApiService);
    }

    @Test
    public void shouldGetNewsCorrect() throws IOException {

        // given
        final News mock = NewsMocker.getNews(COUNTRY, CATEGORY);
        when(newsApiService.getNews(COUNTRY, CATEGORY)).thenReturn(NewsResponseMocker.getNewsResponse());

        // when
        final News result = newsService.getNews(COUNTRY, CATEGORY);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(mock);
    }

    @Test(expected = FailedDependencyException.class)
    public void shouldGetNewsThrowDependencyException() throws IOException {

        // given
        final News mock = NewsMocker.getNews(COUNTRY, CATEGORY);
        when(newsApiService.getNews(COUNTRY, CATEGORY)).thenThrow(new IOException());

        // when
        final News result = newsService.getNews(COUNTRY, CATEGORY);
    }
}