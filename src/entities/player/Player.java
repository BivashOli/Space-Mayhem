package com.shockgamez.entities.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.shockgamez.entities.Entity;
import com.shockgamez.gfx.Texture;
import com.shockgamez.main.Display;

public class Player extends Entity{
	
	public static int health = 10, score = 0;
	
	public Player(float x, float y) {
		super(x, y);
	}

	protected void init() {
		width = 45;
		height = 45;
		
		texture = Texture.loadImage("/player.png"); 
	}

	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, width, height, null);
	}

	public void update() {
		x+=velX;
		y+=velY;
		
		if(x < 0){
			x = 0;
		}
		if(x > Display.WIDTH-width){
			x = Display.WIDTH-width;
		}
		if(y < 0){
			y = 0;
		}
		if(y > Display.HEIGHT-height){
			y = Display.HEIGHT-width;
		}
	}
	

}
