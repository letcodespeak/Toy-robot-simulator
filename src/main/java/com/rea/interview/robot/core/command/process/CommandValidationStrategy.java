package com.rea.interview.robot.core.command.process;

public interface CommandValidationStrategy {

    /*
     * @return 0 means validation succeeds.
     *        -1 means validation failure.
     *        -2 means running other commands ahead of init.
     */
    public int validate();

}
