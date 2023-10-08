package com.springwebflux.stocktrading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class StockCreationException extends RuntimeException {

    public StockCreationException(String message) {
        super(message);
    }

    public ProblemDetail asProblemDetail() {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND, getMessage());
        problemDetail.setTitle("Unable to Create Stock");
        return problemDetail;
    }
}
