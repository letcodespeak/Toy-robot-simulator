package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.CarLocation;

public class ReportCommand implements Command {

    public ReportCommand() {
        super();
    }

    @Override
    public void execute(String[] commands) {

        CarLocation cl = CarLocation.getInstance();

        System.out.println(String.format("Output: %d,%d,%s", cl.getX(), cl.getY(), cl.getDirection()));

    }

}
