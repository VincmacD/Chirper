package com.cst8277.messagingservice.handler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public String getStatusCode() {
        return Integer.toString(httpStatus.value());
    }

}
