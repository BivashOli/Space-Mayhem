package com.shockgamez.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.shockgamez.main.Display;

public class PauseState {

	private int resumeX = Display.WIDTH/2-400, resumeY = Display.HEIGHT/2-50;
	private int menuX = Display.WIDTH/2+100, menuY = Display.HEIGHT/2-50; 
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Serif", Font.PLAIN, 80));
		
		
		g.drawString("Resume", resumeX+20, resumeY+90); 
		g.drawString("Menu", menuX+60, menuY+90);
		
		g.drawRect(resumeX, resumeY, 300, 150);
 		g.drawRect(menuX, menuY, 300, 150);
		
	}

	public int getResumeX() {
		return resumeX;
	}

	public void setResumeX(int resumeX) {
		this.resumeX = resumeX;
	}

	public int getResumeY() {
		return resumeY;
	}

	public void setResumeY(int resumeY) {
		this.resumeY = resumeY;
	}

	public int getMenuX() {
		return menuX;
	}

	public void setMenuX(int menuX) {
		this.menuX = menuX;
	}

	public int getMenuY() {
		return menuY;
	}

	public void setMenuY(int menuY) {
		this.menuY = menuY;
	}
}
