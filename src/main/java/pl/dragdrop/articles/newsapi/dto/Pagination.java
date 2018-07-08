package pl.dragdrop.articles.newsapi.dto;

import java.util.Optional;

public class Pagination {
    public static Integer totalArticles;
    public static Integer pageSize;
    public static Integer pageIndex;

    public static void setPageSize(String size) {
        Optional<String> optional = Optional.ofNullable(size);
        Pagination.pageSize = optional.map(Integer::valueOf).orElse(null);
    }

    public static void setPageIndex(String page) {
        Optional<String> optional = Optional.ofNullable(page);
        Pagination.pageIndex = optional.map(Integer::valueOf).orElse(null);
    }

    public static void setTotalArticles(Integer totalArticles) {
        Optional<Integer> optional = Optional.ofNullable(totalArticles);
        Pagination.totalArticles = optional.orElse(0);
    }
}
