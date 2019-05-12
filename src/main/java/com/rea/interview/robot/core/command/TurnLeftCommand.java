package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.CarLocation;

public class TurnLeftCommand implements Command {

    public TurnLeftCommand() {
        super();
    }

    @Override
    public void execute(String[] commands) {
        if (CarLocation.getInstance().getDirection().equalsIgnoreCase("NORTH")) {
            CarLocation.getInstance().setDirection("WEST");
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("SOUTH")) {
            CarLocation.getInstance().setDirection("EAST");
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("EAST")) {
            CarLocation.getInstance().setDirection("NORTH");
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("WEST")) {
            CarLocation.getInstance().setDirection("SOUTH");
        }

    }

}
