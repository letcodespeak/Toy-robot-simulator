package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.RobotLocation;

public class TurnLeftCommand implements Command {

    public TurnLeftCommand() {
        super();
    }

    @Override
    public void execute(String[] commands) {
        if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("NORTH")) {
            RobotLocation.getInstance().setDirection("WEST");
        } else if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("SOUTH")) {
            RobotLocation.getInstance().setDirection("EAST");
        } else if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("EAST")) {
            RobotLocation.getInstance().setDirection("NORTH");
        } else if (RobotLocation.getInstance().getDirection().equalsIgnoreCase("WEST")) {
            RobotLocation.getInstance().setDirection("SOUTH");
        }

    }

}
