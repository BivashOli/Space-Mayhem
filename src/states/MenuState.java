package com.shockgamez.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.shockgamez.main.Display;

public class MenuState {

	private int playX = Display.WIDTH/2-300, playY = Display.HEIGHT/2+50;
	private int exitX = Display.HEIGHT/2+300, exitY = Display.HEIGHT/2+50;
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Serif", Font.PLAIN, 80)); 
		g.drawString(Display.TITLE, Display.WIDTH/2-250, Display.HEIGHT/2-100); 
		
		g.setFont(new Font("Serif", Font.PLAIN, 80)); 
		g.drawString("Play", playX+25, playY+75); 
		g.drawString("Exit", exitX+25,exitY+75); 
		
		g.drawRect(playX, playY, 200, 100);
		g.drawRect(exitX, exitY, 200, 100); 
	}

	public int getPlayX() {
		return playX;
	}

	public void setPlayX(int playX) {
		this.playX = playX;
	}

	public int getPlayY() {
		return playY;
	}

	public void setPlayY(int playY) {
		this.playY = playY;
	}

	public int getExitX() {
		return exitX;
	}

	public void setExitX(int exitX) {
		this.exitX = exitX;
	}

	public int getExitY() {
		return exitY;
	}

	public void setExitY(int exitY) {
		this.exitY = exitY;
	}
}
