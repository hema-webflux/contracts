package hema.web.contracts.http;

public class HttpException extends RuntimeException implements HttpExceptionInterface {

    private final int statusCode;

    private final String message;

    public HttpException(int code, String message, Throwable throwable) {
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
