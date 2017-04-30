package com.shockgamez.entities.bullet;

import java.awt.Graphics;
import java.util.LinkedList;

import com.shockgamez.entities.Entity;

public class BulletManager {

	public LinkedList<Bullet> bullets = new LinkedList<Bullet>();

	public void render(Graphics g) {
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(g); 
		}
	}

	public void update() {
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).update();
			if(bullets.get(i).getY() < 0){
				removeBullet(bullets.get(i)); 
			}
		}
		
	}

	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}

	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
	}

}
