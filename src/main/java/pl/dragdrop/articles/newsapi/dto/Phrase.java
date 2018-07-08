package pl.dragdrop.articles.newsapi.dto;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;

@Slf4j
public class Phrase {

    public static String phrase;

    public static void setPhrase(String query) {
        Optional<String> optional = Optional.ofNullable(query);
        phrase = optional.map(Phrase::decodeQuery).orElse(null);
    }

    private static String decodeQuery(String query) {
        try {
            return URLDecoder.decode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("", e);
            return null;
        }
    }
}
