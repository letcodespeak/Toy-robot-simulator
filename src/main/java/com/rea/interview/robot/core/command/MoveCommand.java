package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.CarLocation;
import com.rea.interview.robot.core.command.process.CommandBoundaryValidator;
import com.rea.interview.robot.core.command.process.CommandValidationStrategy;

public class MoveCommand implements Command {

    private CommandValidationStrategy boundaryValidator;

    public MoveCommand() {
        super();
    }

    public void execute(String[] commands) {

        int[] coordinate = this.calculateCoordinate();

        boundaryValidator = new CommandBoundaryValidator(coordinate[0], coordinate[1]);

        if (boundaryValidator.validate() >= 0) {
            CarLocation.getInstance()
                .setX(coordinate[0]);
            CarLocation.getInstance()
                .setY(coordinate[1]);

        }

    }

    private int[] calculateCoordinate() {

        int[] coordinate = new int[2];

        if (CarLocation.getInstance().getDirection().equalsIgnoreCase("NORTH")) {
            coordinate[0] = CarLocation.getInstance().getX();
            coordinate[1] = CarLocation.getInstance().getY() + 1;
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("SOUTH")) {
            coordinate[0] = CarLocation.getInstance().getX();
            coordinate[1] = CarLocation.getInstance().getY() - 1;
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("EAST")) {
            coordinate[0] = CarLocation.getInstance().getX() + 1;
            coordinate[1] = CarLocation.getInstance().getY();
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("WEST")) {
            coordinate[0] = CarLocation.getInstance().getX() - 1;
            coordinate[1] = CarLocation.getInstance().getY();
        }

        return coordinate;
    }

}
