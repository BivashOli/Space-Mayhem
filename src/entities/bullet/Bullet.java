package com.shockgamez.entities.bullet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.shockgamez.entities.Entity;
import com.shockgamez.gfx.Texture;

public class Bullet extends Entity{
	
	public Bullet(float x, float y) {
		super(x, y);
	}

	protected void init() {
		width = 30;
		height = 30;
		
		velY = -10;
		
		texture = Texture.loadImage("/bullet.png");
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, width, height, null);
	}

	public void update() {
		y+=velY;
	}

}
