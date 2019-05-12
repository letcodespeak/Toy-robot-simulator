package com.rea.interview.robot.core.command;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rea.interview.robot.core.RobotLocation;


public class MoveCommandTest {
	
	Command moveCommand = new MoveCommand();


        @Test
        public void testSuccessfulMove() {
        		
        	RobotLocation.getInstance().setX(0);
        	RobotLocation.getInstance().setY(0);
        	RobotLocation.getInstance().setDirection("NORTH");
        		
                String[] commands = new String[]{"MOVE"};
        	moveCommand.execute(commands);
        	assertEquals(0,RobotLocation.getInstance().getX());
        	assertEquals(1,RobotLocation.getInstance().getY());
        	assertEquals("NORTH",RobotLocation.getInstance().getDirection());
        }
        	
        @Test
        public void testFailedMove() {
        	
        	RobotLocation.getInstance().setX(0);
        	RobotLocation.getInstance().setY(0);
        	RobotLocation.getInstance().setDirection("WEST");
        	
                String[] commands = new String[]{"MOVE"};
        	moveCommand.execute(commands);
        	assertEquals(0,RobotLocation.getInstance().getX());
        	assertEquals(0,RobotLocation.getInstance().getY());
        	assertEquals("WEST",RobotLocation.getInstance().getDirection());
        }

}
