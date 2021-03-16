package com.moacirknipers.app.exceptions;

public class InstallationException extends RuntimeException {
    public InstallationException() {
        super();
    }
    public InstallationException(String message) {
        super(message);
    }
    public InstallationException(String message, Throwable cause) {
        super(message, cause);
    }
    public InstallationException(Throwable cause) {
        super(cause);
    }
}
