package com.rea.interview.robot;

import com.rea.interview.robot.core.command.process.RobotMovementCommandProcessor;
import com.rea.interview.robot.core.command.process.CommandProcessor;
import com.rea.interview.robot.core.input.InputHandler;
import com.rea.interview.robot.util.PropertiesUtil;

public class FeedMain {

    private CommandProcessor processor = new RobotMovementCommandProcessor();

    public FeedMain() {
        super();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        FeedMain am = new FeedMain();

        InputHandler input = (InputHandler) Class.forName(PropertiesUtil.getInstance().getPropertyValue("init.input.source")).newInstance();
        input.init();

        String command = input.nextLine();
        while (command != null && command.length() > 0) {
            am.processor.processCommand(command);
            command = input.nextLine();
        }
        input.close();

    }

}
