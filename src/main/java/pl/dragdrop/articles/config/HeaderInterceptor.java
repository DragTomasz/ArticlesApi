package pl.dragdrop.articles.config;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.dragdrop.articles.newsapi.dto.Pagination;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Optional<String> page = Optional.ofNullable(request.getHeader("page"));
        Optional<String> pageSize = Optional.ofNullable(request.getHeader("page-size"));

        Pagination.pageIndex = page.map(Integer::valueOf).orElse(null);
        Pagination.pageSize = pageSize.map(Integer::valueOf).orElse(null);

        return true;
    }
}
