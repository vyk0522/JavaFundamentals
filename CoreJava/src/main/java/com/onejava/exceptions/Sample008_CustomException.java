package com.onejava.exceptions;

public class Sample008_CustomException {
    public static void main(String[] args) {
        checked();
        unChecked();
    }

    private static void checked() {
        try {
            throw new CheckedException("Checked Custom exception");
        } catch (CheckedException e) {
        }
    }

    private static void unChecked() {
        throw new UserNotFoundException("User is not Found");
    }


}

class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}

class CheckedException extends Exception{
    public CheckedException(String message) {
        super(message);
    }
}
