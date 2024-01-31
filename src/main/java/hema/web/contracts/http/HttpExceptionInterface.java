package hema.web.contracts.http;

public interface HttpExceptionInterface {

    /**
     * @return status code
     */
    int getStatusCode();

    /**
     * @return error message.
     */
    String getMessage();

}
