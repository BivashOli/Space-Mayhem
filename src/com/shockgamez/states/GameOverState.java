package com.shockgamez.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.shockgamez.main.Display;

public class GameOverState {

	private int playAgainX = Display.WIDTH/2-400, playAgainY = Display.HEIGHT/2-50;
	private int menuX = Display.WIDTH/2+100, menuY = Display.HEIGHT/2-50;
	
	public void render(Graphics g){
		g.setColor(Color.WHITE); 
		
		g.drawRect(playAgainX, playAgainY, 300, 150); 
		g.drawRect(menuX, menuY, 300, 150); 
		
		g.setFont(new Font("Serif", Font.PLAIN, 60)); 
		g.drawString("Play Again", playAgainX+20, playAgainY+90);
		g.drawString("Menu", menuX+80, menuY+90); 
		
	}

	public int getPlayAgainX() {
		return playAgainX;
	}

	public void setPlayAgainX(int playAgainX) {
		this.playAgainX = playAgainX;
	}

	public int getPlayAgainY() {
		return playAgainY;
	}

	public void setPlayAgainY(int playAgainY) {
		this.playAgainY = playAgainY;
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
