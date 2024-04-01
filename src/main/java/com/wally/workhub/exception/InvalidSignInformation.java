package com.wally.workhub.exception;

public class InvalidSignInformation extends WorkhubException {

    private static final String MESSAGE = "Invalid sign information";

    public InvalidSignInformation() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
