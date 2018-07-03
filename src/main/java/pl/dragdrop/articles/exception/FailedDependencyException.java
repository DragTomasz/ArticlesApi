package pl.dragdrop.articles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class FailedDependencyException extends RuntimeException {

    public FailedDependencyException(String message) {
        super(message);
    }
}
