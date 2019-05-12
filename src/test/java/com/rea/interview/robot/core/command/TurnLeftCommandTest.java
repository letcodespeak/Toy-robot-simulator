package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.CarLocation;


public class TurnLeftCommandTest {

	
	Command turnLeftCommand = new TurnLeftCommand();
	


	@Test
	public void testSuccessfulTurnLeft() {
		
	    CarLocation.getInstance().setX(0);
	    CarLocation.getInstance().setY(0);
	    CarLocation.getInstance().setDirection("NORTH");
		
            String[] commands = new String[]{"LEFT"};
            turnLeftCommand.execute(commands);
            assertEquals(0,CarLocation.getInstance().getX());
            assertEquals(0,CarLocation.getInstance().getY());
            assertEquals("WEST",CarLocation.getInstance().getDirection());
	}
	


}
