package pl.dragdrop.articles.newsapi;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import pl.dragdrop.articles.newsapi.dto.NewsResponse;
import pl.dragdrop.articles.testutils.NewsResponseMocker;

import retrofit2.mock.Calls;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class NewsApiServiceTest {

    private final String COUNTRY = "pl";
    private final String CATEGORY = "technology";

    @Mock
    private NewsApiEndpoint newsApiEndpoint;

    @Mock
    private NewsApiService newsService;

    @Before
    public void init() {
        initMocks(this);
        newsService = new NewsApiService(newsApiEndpoint);
    }

    @Test
    public void shouldCallSuccess() throws IOException {

        // given
        final NewsResponse mock = NewsResponseMocker.getNewsResponse();
        when(newsApiEndpoint.getNews(anyString(), anyString())).thenReturn(Calls.response(mock));

        // when
        final NewsResponse result = newsService.getNews(COUNTRY, CATEGORY);

        // then
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(mock);

        verify(newsApiEndpoint).getNews(COUNTRY, CATEGORY);
    }

    @Test(expected = IOException.class)
    public void shouldCallThrowIOExceptionFailure() throws IOException {

        // given
        when(newsApiEndpoint.getNews(anyString(), anyString())).thenReturn(Calls.failure(new IOException()));
        // when
        final NewsResponse result = newsService.getNews(COUNTRY, CATEGORY);
    }
}