package hema.web.contracts.http;

import hema.web.contracts.HttpExceptionInterface;

public class HttpException extends RuntimeException implements HttpExceptionInterface {

    private final int statusCode;

    private final String message;

    public HttpException(int code, String message) {
        super(message);
        this.statusCode = code;
        this.message = message;
    }

    public HttpException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.statusCode = code;
        this.message = message;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
