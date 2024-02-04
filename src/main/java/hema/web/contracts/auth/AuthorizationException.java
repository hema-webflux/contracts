package hema.web.contracts.auth;

import hema.web.contracts.http.HttpException;

public class AuthorizationException extends HttpException {
    public AuthorizationException(int code, String message) {
        super(code, message);
    }
}
