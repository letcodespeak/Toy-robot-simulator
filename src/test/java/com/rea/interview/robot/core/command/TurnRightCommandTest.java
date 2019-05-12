package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.RobotLocation;

public class TurnRightCommandTest {

	Command turnRightCommand = new TurnRightCommand();
	


	@Test
	public void testSuccessfulTurnLeft() {
		
	    RobotLocation.getInstance().setX(0);
	    RobotLocation.getInstance().setY(0);
	    RobotLocation.getInstance().setDirection("EAST");
		
            String[] commands = new String[]{"RIGHT"};
            turnRightCommand.execute(commands);
            assertEquals(0,RobotLocation.getInstance().getX());
            assertEquals(0,RobotLocation.getInstance().getY());
            assertEquals("SOUTH",RobotLocation.getInstance().getDirection());
	}


	
}
