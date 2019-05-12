package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.CarLocation;
import com.rea.interview.robot.core.command.process.CommandBoundaryValidator;
import com.rea.interview.robot.core.command.process.CommandValidationStrategy;

public class PlaceCommand implements Command {

    private CommandValidationStrategy boundaryValidator;

    public PlaceCommand() {
        super();
    }

    public void execute(String[] commands) {

        boundaryValidator = new CommandBoundaryValidator(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));

        if (boundaryValidator.validate() >= 0) {
            CarLocation.getInstance().setX(Integer.parseInt(commands[1]));
            CarLocation.getInstance().setY(Integer.parseInt(commands[2]));
            CarLocation.getInstance().setDirection(commands[3]);
        }

    }

}
