package com.Ltuc.BcryptProj.exceptions;

public class PostsNotFound extends RuntimeException {

    public PostsNotFound(String message) {
        super(message);
    }

    public PostsNotFound(Throwable cause) {
        super(cause);
    }

}
