package com.moacirknipers.app.exceptions;

public class InvoiceException extends RuntimeException {
    public InvoiceException() {
        super();
    }
    public InvoiceException(String message) {
        super(message);
    }
    public InvoiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvoiceException(Throwable cause) {
        super(cause);
    }
}
