package pl.dragdrop.articles.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import pl.dragdrop.articles.dto.News;
import pl.dragdrop.articles.newsapi.dto.Pagination;

@RestControllerAdvice
public class HeaderModifier implements ResponseBodyAdvice<News> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getMethod().getName().equals("getNewsByCountryAndCategory");
    }

    @Override
    public News beforeBodyWrite(News body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().add("access-control-expose-headers", "X-Total-Count");
        response.getHeaders().add("X-Total-Count", Pagination.totalArticles.toString());
        return body;
    }
}