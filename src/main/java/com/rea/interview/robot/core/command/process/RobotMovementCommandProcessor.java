package com.rea.interview.robot.core.command.process;

import java.util.ArrayList;
import java.util.List;

import com.rea.interview.robot.core.command.Command;
import com.rea.interview.robot.core.command.CommandFactory;
import com.rea.interview.robot.util.CommandUtil;

public class RobotMovementCommandProcessor implements CommandProcessor {

    private CommandValidationStrategy validator;

    public RobotMovementCommandProcessor() {
        super();
    }

    private String[] transformCommands(String command) {

        List<String> commands = new ArrayList<String>();
        String[] components = command.split("\\s");
        String leadingKey = components[0];
        commands.add(leadingKey);

        if (leadingKey.equalsIgnoreCase("PLACE")) {
            String[] parameters = components[1].split(",");
            commands.add(parameters[0]);
            commands.add(parameters[1]);
            commands.add(parameters[2]);
        }

        return commands.toArray(new String[commands.size()]);
    }

    @Override
    public void processCommand(String command) {
        validator = new CommandSyntaxValidator(command);

        int validated = validator.validate();

        if (validated >= 0) {

            String[] commands = transformCommands(command);

            Command runC = CommandFactory.getInstance().getRegisteredCommand(commands[0]);
            runC.execute(commands);

        } else if (validated == -1) { // command syntax error
            CommandUtil.printCommandTips();
        } else if (validated == -2) { // lack of init command
            CommandUtil.printInitCommandTips();
        }

    }

}
