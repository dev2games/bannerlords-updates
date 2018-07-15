package com.dev2games.bannerlords.updates.frame;

import javax.swing.JFrame;

/**
 * <p>Handles loading the main GUI for our application</p>
 * @author Nelson Sanchez
 */

//TODO add a JFrame to the application
public class ApplicationFrame {
	
	JFrame frame;
	
	public ApplicationFrame() {
		//Initializes the JFrame
		frame = new JFrame("Taleworlds Forum Updates");
		//Makes it so the application closes on click
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
