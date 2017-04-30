package com.shockgamez.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.shockgamez.entities.bullet.Bullet;
import com.shockgamez.entities.bullet.BulletManager;
import com.shockgamez.entities.enemies.Enemy;
import com.shockgamez.entities.enemies.EnemyManager;
import com.shockgamez.entities.player.Player;
import com.shockgamez.gfx.Texture;
import com.shockgamez.main.Display;
import com.shockgamez.main.Game;

public class GameState {

	private BufferedImage background;
	
	private Player player;
	private BulletManager bulletmanager;
	private EnemyManager enemymanager;

	public GameState() {
		init();
	}

	private void init() {
		background = Texture.loadImage("/background.png");
		
		player = new Player(Display.WIDTH / 2 - 32, Display.HEIGHT);
		bulletmanager = new BulletManager();
		enemymanager = new EnemyManager();
	}

	public void render(Graphics g) {
		g.drawImage(background, 0, 0, null);
		
		player.render(g);
		bulletmanager.render(g);
		enemymanager.render(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.PLAIN, 25));
		g.drawString("Health: " + String.valueOf(Player.health), 0, 25);
		g.drawString("Score: " + String.valueOf(Player.score), 200, 25);
	}

	public void update() {
		player.update();
		bulletmanager.update();
		enemymanager.update();

		if (Player.health <= 0) {
			reset();
			Game.state = State.GAMEOVER;
		}

		collision();
	}

	private void collision() {

		for (int i = 0; i < enemymanager.enemies.size(); i++) {
			Enemy enemy = enemymanager.enemies.get(i);
			if (player.getBounds().intersects(enemy.getBounds())) {
				Player.health--;
			}
			if (enemy.getY() >= Display.HEIGHT) {
				Player.health--;
			}
		}
		for (int i = 0; i < bulletmanager.bullets.size(); i++) {
			for (int i2 = 0; i2 < enemymanager.enemies.size(); i2++) {
				Bullet bullet = bulletmanager.bullets.get(i);
				Enemy enemy = enemymanager.enemies.get(i2);

				if (bullet.getBounds().intersects(enemy.getBounds())) {
					enemy.setHealth(enemy.getHealth() - 1);
				}
			}
		}
	}

	public void reset() {
		Player.health = 10;
		Player.score = 0;

		player.setX(Display.WIDTH / 2 - 32);
		player.setY(Display.HEIGHT - 100);

		enemymanager.setEnemyTotal(1);
		enemymanager.setEnemyAmount(0);
		enemymanager.setEnemyDestroyed(0);
		for (int i = 0; i < enemymanager.enemies.size(); i++) {
			enemymanager.enemies.remove(i);
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BulletManager getBulletmanager() {
		return bulletmanager;
	}

	public void setBulletmanager(BulletManager bulletmanager) {
		this.bulletmanager = bulletmanager;
	}

	public EnemyManager getEnemymanager() {
		return enemymanager;
	}

	public void setEnemymanager(EnemyManager enemymanager) {
		this.enemymanager = enemymanager;
	}
}
