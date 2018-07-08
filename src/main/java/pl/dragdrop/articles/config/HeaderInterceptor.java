package pl.dragdrop.articles.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.dragdrop.articles.newsapi.dto.Pagination;
import pl.dragdrop.articles.newsapi.dto.Phrase;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Phrase.setPhrase(request.getHeader("phrase"));
        Pagination.setPageIndex(request.getHeader("page"));
        Pagination.setPageSize(request.getHeader("page-size"));
        return true;
    }
}
