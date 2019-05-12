package com.rea.interview.robot.core.command;

import com.rea.interview.robot.core.RobotLocation;

public class ReportCommand implements Command {

    public ReportCommand() {
        super();
    }

    @Override
    public void execute(String[] commands) {

        RobotLocation cl = RobotLocation.getInstance();

        System.out.println(String.format("Output: %d,%d,%s", cl.getX(), cl.getY(), cl.getDirection()));

    }

}
