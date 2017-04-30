package com.shockgamez.entities.enemies;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.shockgamez.entities.player.Player;
import com.shockgamez.main.Display;

public class EnemyManager {

	private Random r = new Random();

	private int enemyAmount = 0, enemyTotal = 1, enemyDestroyed = 0,spawnChance = r.nextInt(3) + 1;
	private float enemyX = r.nextInt(Display.WIDTH-32), enemyY = 0;
	
	public LinkedList<Enemy> enemies = new LinkedList<Enemy>();


	public void render(Graphics g) {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}
	}

	public void update() {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
			if (enemies.get(i).getY() > Display.HEIGHT ||enemies.get(i).getHealth() <= 0) {
				removeEnemy(enemies.get(i));
				Player.score+=10;
				enemyDestroyed++;
				if(enemyDestroyed == enemyTotal){
					if(!(enemyTotal > 6)){
					enemyTotal*=2;
					}else{
						enemyTotal+=4;
					}
				}
			}
		}
		spawn();
	}

	private void spawn() {
		
		for (enemyAmount = enemyAmount; enemyAmount < enemyTotal; enemyAmount++) {
			switch (spawnChance) {
			case 1:
				addEnemy(new Grunt(enemyX, enemyY));

				break;
			case 2:
				addEnemy(new Tank(enemyX, enemyY));

				break;
			case 3: addEnemy(new Ship(enemyX, enemyY));

				break;
			}
			spawnChance = r.nextInt(3)+1;
			enemyX = r.nextInt(Display.WIDTH - 32);
		}
	}

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}

	public int getEnemyTotal() {
		return enemyTotal;
	}

	public void setEnemyTotal(int enemyTotal) {
		this.enemyTotal = enemyTotal;
	}

	public float getEnemyX() {
		return enemyX;
	}

	public void setEnemyX(float enemyX) {
		this.enemyX = enemyX;
	}

	public float getEnemyY() {
		return enemyY;
	}

	public void setEnemyY(float enemyY) {
		this.enemyY = enemyY;
	}

	public LinkedList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(LinkedList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public int getEnemyAmount() {
		return enemyAmount;
	}

	public void setEnemyAmount(int enemyAmount) {
		this.enemyAmount = enemyAmount;
	}

	public int getEnemyDestroyed() {
		return enemyDestroyed;
	}

	public void setEnemyDestroyed(int enemyDestroyed) {
		this.enemyDestroyed = enemyDestroyed;
	}

	public int getSpawnChance() {
		return spawnChance;
	}

	public void setSpawnChance(int spawnChance) {
		this.spawnChance = spawnChance;
	}
}
