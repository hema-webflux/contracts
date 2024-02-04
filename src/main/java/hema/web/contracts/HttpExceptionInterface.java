package hema.web.contracts;

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
