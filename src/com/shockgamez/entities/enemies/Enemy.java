package com.shockgamez.entities.enemies;

import com.shockgamez.entities.Entity;

public abstract class Enemy extends Entity{

	protected int health, attack, level;
	
	public Enemy(float x, float y) {
		super(x, y);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
