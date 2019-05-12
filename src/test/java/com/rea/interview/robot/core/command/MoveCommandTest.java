package com.rea.interview.robot.core.command;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rea.interview.robot.core.CarLocation;


public class MoveCommandTest {
	
	Command moveCommand = new MoveCommand();


        @Test
        public void testSuccessfulMove() {
        		
        	CarLocation.getInstance().setX(0);
        	CarLocation.getInstance().setY(0);
        	CarLocation.getInstance().setDirection("NORTH");
        		
                String[] commands = new String[]{"MOVE"};
        	moveCommand.execute(commands);
        	assertEquals(0,CarLocation.getInstance().getX());
        	assertEquals(1,CarLocation.getInstance().getY());
        	assertEquals("NORTH",CarLocation.getInstance().getDirection());
        }
        	
        @Test
        public void testFailedMove() {
        	
        	CarLocation.getInstance().setX(0);
        	CarLocation.getInstance().setY(0);
        	CarLocation.getInstance().setDirection("WEST");
        	
                String[] commands = new String[]{"MOVE"};
        	moveCommand.execute(commands);
        	assertEquals(0,CarLocation.getInstance().getX());
        	assertEquals(0,CarLocation.getInstance().getY());
        	assertEquals("WEST",CarLocation.getInstance().getDirection());
        }

}
