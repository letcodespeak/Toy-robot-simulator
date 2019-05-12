package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.CarLocation;

public class TurnRightCommandTest {

	Command turnRightCommand = new TurnRightCommand();
	


	@Test
	public void testSuccessfulTurnLeft() {
		
	    CarLocation.getInstance().setX(0);
	    CarLocation.getInstance().setY(0);
	    CarLocation.getInstance().setDirection("EAST");
		
            String[] commands = new String[]{"RIGHT"};
            turnRightCommand.execute(commands);
            assertEquals(0,CarLocation.getInstance().getX());
            assertEquals(0,CarLocation.getInstance().getY());
            assertEquals("SOUTH",CarLocation.getInstance().getDirection());
	}


	
}
