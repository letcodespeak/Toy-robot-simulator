package com.rea.interview.robot.util;

public class CommandUtil {

    public CommandUtil() {
        super();
    }

    public static void printCommandTips() {

        System.out.println("The acceptable commands are as follows ");
        System.out.println("  PLACE <X>,<Y>,<F>");
        System.out.println("  MOVE");
        System.out.println("  LEFT");
        System.out.println("  RIGHT");
        System.out.println("  REPORT");

    }

    public static void printInitCommandTips() {

        System.out.println("The car movement must to be initialized by following command first ");
        System.out.println("  PLACE <X>,<Y>,<F>");

    }

}
