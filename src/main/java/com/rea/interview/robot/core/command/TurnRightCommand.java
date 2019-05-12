package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.CarLocation;

public class TurnRightCommand implements Command {

    public TurnRightCommand() {
        super();
    }

    @Override
    public void execute(String[] commands) {

        if (CarLocation.getInstance().getDirection().equalsIgnoreCase("NORTH")) {
            CarLocation.getInstance().setDirection("EAST");
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("SOUTH")) {
            CarLocation.getInstance().setDirection("WEST");
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("EAST")) {
            CarLocation.getInstance().setDirection("SOUTH");
        } else if (CarLocation.getInstance().getDirection().equalsIgnoreCase("WEST")) {
            CarLocation.getInstance().setDirection("NORTH");
        }

    }

}
