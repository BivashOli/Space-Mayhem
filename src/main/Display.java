package com.shockgamez.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	public static final int WIDTH = 1200, HEIGHT = 800;
	public static final String TITLE = "Space Mayhem";
	
	private JFrame frame;
	private Canvas canvas;
	
	public Display(){
		init();
		window();
	}
	
	private void init(){
		frame = new JFrame(TITLE);
		canvas = new Canvas();
	}
	
	private void window() {
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT)); 
		
		frame.add(canvas);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		canvas.setFocusable(true); 
		frame.setVisible(true); 
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
