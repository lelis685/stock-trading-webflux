package com.springwebflux.stocktrading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException(String message) {
        super(message);
    }

    public ProblemDetail asProblemDetail() {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST, getMessage());
        problemDetail.setTitle("Stock Not Found");
        return problemDetail;
    }
}
