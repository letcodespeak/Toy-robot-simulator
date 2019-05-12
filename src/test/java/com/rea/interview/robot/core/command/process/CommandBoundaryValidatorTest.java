package com.rea.interview.robot.core.command.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandBoundaryValidatorTest {

    private CommandValidationStrategy commandValidator;

    @Test
    public void testValidationSuccess() {
        commandValidator = new CommandBoundaryValidator(4, 3);
        assertEquals(0, commandValidator.validate());

    }

    @Test
    public void testValidationOutofBoundary() {
        commandValidator = new CommandBoundaryValidator(7, 9);
        assertEquals(-1, commandValidator.validate());

    }

}
