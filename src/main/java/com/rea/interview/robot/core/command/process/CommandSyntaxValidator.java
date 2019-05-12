package com.rea.interview.robot.core.command.process;

import com.rea.interview.robot.core.RobotLocation;
import com.rea.interview.robot.util.IConstant;
import com.rea.interview.robot.util.PropertiesUtil;

public class CommandSyntaxValidator implements CommandValidationStrategy {

    private String command;

    public CommandSyntaxValidator(String command) {
        super();
        this.command = command;

    }

    @Override
    public int validate() {

        if (command == null || command.length() <= 0)
            return -1;

        int result = 0;

        try {

            String[] commandParts = command.split("\\s");

            if (commandParts.length <= 0 || commandParts.length >= 3) {
                result = -1;
            }
            String commandSets = PropertiesUtil.getInstance()
                .getPropertyValue("init.commandset");

            String leadingKey = commandParts[0];
            if (!commandSets.contains(leadingKey)) {
                result = -1;
            }

            if (leadingKey.equalsIgnoreCase(IConstant.COMMAND_PLACE)) {
                if (commandParts.length != 2) {
                    result = -1;
                }

                String[] parameters = commandParts[1].split(",");

                if (parameters.length <= 0 || parameters.length > 3) {
                    result = -1;
                }

                int x_tobe = Integer.parseInt(parameters[0]);
                int y_tobe = Integer.parseInt(parameters[1]);
                String direction_tobe = parameters[2];
                String directions = PropertiesUtil.getInstance()
                    .getPropertyValue("init.command.directionset");
                if (directions.indexOf(direction_tobe) == -1) {
                    result = -1;
                }

            } else {

                if (!RobotLocation.getInstance()
                    .isInitialized()) { // not initialized yet. Run init first.
                    // CommandUtil.printInitCommandTips();
                    result = -2;
                }

                if (commandParts.length != 1) {
                    result = -1;
                }
            }

        } catch (NumberFormatException e) {
            result = -1;
        }

        return result;

    }

}
