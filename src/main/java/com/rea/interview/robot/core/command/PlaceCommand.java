package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.RobotLocation;
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
            RobotLocation.getInstance().setX(Integer.parseInt(commands[1]));
            RobotLocation.getInstance().setY(Integer.parseInt(commands[2]));
            RobotLocation.getInstance().setDirection(commands[3]);
        }

    }

}
