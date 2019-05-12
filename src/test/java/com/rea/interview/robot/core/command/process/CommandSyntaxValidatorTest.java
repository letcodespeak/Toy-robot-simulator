package com.rea.interview.robot.core.command.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.CarLocation;
import com.rea.interview.robot.core.command.Command;
import com.rea.interview.robot.core.command.PlaceCommand;

public class CommandSyntaxValidatorTest {

    private CommandValidationStrategy commandValidator;

    @Test
    public void testValidationSuccess() {
        commandValidator = new CommandSyntaxValidator("PLACE 0,0,NORTH");
        assertEquals(0, commandValidator.validate());
    }

    @Test
    public void testValidationFailure() {
        commandValidator = new CommandSyntaxValidator("PLACE a,b,NORTH");
        assertEquals(-1, commandValidator.validate());
    }

    @Test
    public void testValidationSyntaxError() {
        commandValidator = new CommandSyntaxValidator("PLACE 3,NORTH");
        assertEquals(-1, commandValidator.validate());
    }

    @Test
    public void testValidationSyntaxErrorWithInitgoesfirst() {

        String[] commands = new String[] { "PLACE", "0", "1", "EAST" };
        Command initCommand = new PlaceCommand();
        initCommand.execute(commands);

        commandValidator = new CommandSyntaxValidator("TURNLEFT");
        assertEquals(-1, commandValidator.validate());
    }

    @Test
    public void testValidationSyntaxErrorNoFirstInit() {

        CarLocation.getInstance().reset();
        commandValidator = new CommandSyntaxValidator("TURN_LEFT");
        assertEquals(-2, commandValidator.validate());
    }

}
