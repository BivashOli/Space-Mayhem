package com.shockgamez.entities.enemies;

import java.awt.Color;
import java.awt.Graphics;

import com.shockgamez.gfx.Texture;


public class Ship extends Enemy{
	
	public Ship(float x, float y) {
		super(x, y);
	}

	protected void init() {
		width = 45;
		height = 45;
		
		health = 15;
		velY = 1;
		
		texture = Texture.loadImage("/ship.png");
	}

	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, width, height, null);
	}

	public void update() {
		y+=velY;
	
	}

}
