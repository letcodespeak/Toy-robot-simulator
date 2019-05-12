package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.RobotLocation;

public class TurnRightCommand implements Command {

    public TurnRightCommand() {
        super();
    }

    @Override
    public void execute(String[] commands) {

        if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("NORTH")) {
            RobotLocation.getInstance().setDirection("EAST");
        } else if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("SOUTH")) {
            RobotLocation.getInstance().setDirection("WEST");
        } else if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("EAST")) {
            RobotLocation.getInstance().setDirection("SOUTH");
        } else if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("WEST")) {
            RobotLocation.getInstance().setDirection("NORTH");
        }

    }

}
