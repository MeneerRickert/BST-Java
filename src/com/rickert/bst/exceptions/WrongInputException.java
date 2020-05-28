package com.rickert.bst.exceptions;

public class WrongInputException extends Exception {

    public WrongInputException() {
        super("Input is not a compatible object");
    }
}