package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rea.interview.robot.core.RobotLocation;

public class ReportCommandTest {

    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    Command reportCommand = new ReportCommand();

    @Before
    public void setUp() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void testExecute() {
        RobotLocation.getInstance().setX(0);
        RobotLocation.getInstance().setY(0);
        RobotLocation.getInstance().setDirection("EAST");

        String[] commands = new String[] { "REPORT" };
        reportCommand.execute(commands);

        assertEquals("Output: 0,0,EAST\r\n", bytes.toString());

    }

}
