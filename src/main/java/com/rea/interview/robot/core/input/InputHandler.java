package com.rea.interview.robot.core.input;

public interface InputHandler {

    default public boolean init() {
        return true;
    }

    public String nextLine();

    default public void close() {

    }
}
