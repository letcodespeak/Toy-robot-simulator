package com.rea.interview.robot.core.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.interview.robot.core.RobotLocation;

public class PlaceCommandTest {

	Command placeCommand = new PlaceCommand();
	
	@Test
	public void testSuccessfulInit() {
		
		RobotLocation.getInstance().setX(0);
		RobotLocation.getInstance().setY(0);
		RobotLocation.getInstance().setDirection("NORTH");
		
                String[] commands = new String[]{"PLACE","0","1","EAST"};
                placeCommand.execute(commands);
		assertEquals(0,RobotLocation.getInstance().getX());
		assertEquals(1,RobotLocation.getInstance().getY());
		assertEquals("EAST",RobotLocation.getInstance().getDirection());
	}
	
	@Test
	public void testFailedInit() {
		
		RobotLocation.getInstance().reset();
		String[] commands = new String[]{"PLACE","0","-1","EAST"};
		placeCommand.execute(commands);
		assertEquals(-1,RobotLocation.getInstance().getX());
		assertEquals(-1,RobotLocation.getInstance().getY());
		assertEquals("N/A",RobotLocation.getInstance().getDirection());
	}

}
