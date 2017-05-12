package com.shockgamez.entities.enemies;

import java.awt.Color;
import java.awt.Graphics;

import com.shockgamez.gfx.Texture;

public class Tank extends Enemy {

	public Tank(float x, float y) {
		super(x, y);
	}

	protected void init() {
		width = 45;
		height = 45;

		velY = 1.5f;
		health = 10;

		texture = Texture.loadImage("/tank.png");
	}

	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, width, height, null);
	}

	public void update() {
		y += velY;
	}

}
