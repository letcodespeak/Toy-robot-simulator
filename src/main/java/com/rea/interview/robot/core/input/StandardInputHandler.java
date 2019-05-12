package com.rea.interview.robot.core.input;

import java.util.Scanner;

public class StandardInputHandler implements InputHandler {

    private Scanner sa;

    public StandardInputHandler() {
        sa = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        // TODO Auto-generated method stub
        return sa.nextLine();
    }

}
