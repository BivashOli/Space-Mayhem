package com.shockgamez.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Entity {
		
	protected float x, y, velX, velY;
	protected int width, height;
	
	protected Random r = new Random();
	protected BufferedImage texture;
	
	public Entity(float x, float y){
		this.x = x;
		this.y = y;
		
		init();
	}
	
	protected abstract void init();
	
	public abstract void render(Graphics g);
	
	public abstract void update();

	public Rectangle getBounds(){
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
}
