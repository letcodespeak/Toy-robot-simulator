package com.rea.interview.robot.core.exception;

public class InvalidCommandException extends Exception {

    /**
     * Throw when the command received is invalid.
     */
    private static final long serialVersionUID = 554660767883439604L;

    public InvalidCommandException() {
        super();
    }

    public InvalidCommandException(String message) {
        super(message);
    }

}
