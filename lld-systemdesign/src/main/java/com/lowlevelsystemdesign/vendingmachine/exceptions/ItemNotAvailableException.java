package com.lowlevelsystemdesign.vendingmachine.exceptions;

public class ItemNotAvailableException extends RuntimeException{

    public  ItemNotAvailableException(String message) {
        super(message);
    }
}