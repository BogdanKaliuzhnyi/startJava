package com.startjava.lesson_2_3_4.calculator;

public class UnexpectedInputException extends RuntimeException {
    public UnexpectedInputException(String message) {
        super(message);
    }
}