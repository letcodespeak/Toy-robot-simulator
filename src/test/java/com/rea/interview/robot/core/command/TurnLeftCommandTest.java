package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.RobotLocation;


public class TurnLeftCommandTest {

	
	Command turnLeftCommand = new TurnLeftCommand();
	


	@Test
	public void testSuccessfulTurnLeft() {
		
	    RobotLocation.getInstance().setX(0);
	    RobotLocation.getInstance().setY(0);
	    RobotLocation.getInstance().setDirection("NORTH");
		
            String[] commands = new String[]{"LEFT"};
            turnLeftCommand.execute(commands);
            assertEquals(0,RobotLocation.getInstance().getX());
            assertEquals(0,RobotLocation.getInstance().getY());
            assertEquals("WEST",RobotLocation.getInstance().getDirection());
	}
	


}
