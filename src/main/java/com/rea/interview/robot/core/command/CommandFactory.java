package com.rea.interview.robot.core.command;

import java.util.concurrent.ConcurrentHashMap;

import com.rea.interview.robot.util.IConstant;

public final class CommandFactory {

    private CommandFactory() {
        super();
    }

    private final static ConcurrentHashMap<String, Command> registry = new ConcurrentHashMap<>();

    private static interface Singleton {
        final CommandFactory INSTANCE = new CommandFactory();
    }

    static {

        registry.put(IConstant.COMMAND_PLACE, new PlaceCommand());
        registry.put(IConstant.COMMAND_MOVE, new MoveCommand());
        registry.put(IConstant.COMMAND_LEFT, new TurnLeftCommand());
        registry.put(IConstant.COMMAND_RIGHT, new TurnRightCommand());
        registry.put(IConstant.COMMAND_REPORT, new ReportCommand());

    }

    public static CommandFactory getInstance() {
        return Singleton.INSTANCE;
    }

    public Command getRegisteredCommand(String commandKey) {

        return registry.get(commandKey);

    }

}
