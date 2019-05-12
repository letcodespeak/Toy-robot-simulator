package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.CarLocation;

public class PlaceCommandTest {

	Command placeCommand = new PlaceCommand();
	
	@Test
	public void testSuccessfulInit() {
		
		CarLocation.getInstance().setX(0);
		CarLocation.getInstance().setY(0);
		CarLocation.getInstance().setDirection("NORTH");
		
                String[] commands = new String[]{"PLACE","0","1","EAST"};
                placeCommand.execute(commands);
		assertEquals(0,CarLocation.getInstance().getX());
		assertEquals(1,CarLocation.getInstance().getY());
		assertEquals("EAST",CarLocation.getInstance().getDirection());
	}
	
	@Test
	public void testFailedInit() {
		
		CarLocation.getInstance().reset();
		String[] commands = new String[]{"PLACE","0","-1","EAST"};
		placeCommand.execute(commands);
		assertEquals(-1,CarLocation.getInstance().getX());
		assertEquals(-1,CarLocation.getInstance().getY());
		assertEquals("N/A",CarLocation.getInstance().getDirection());
	}

}
