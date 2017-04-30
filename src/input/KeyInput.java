package com.shockgamez.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.shockgamez.entities.bullet.Bullet;
import com.shockgamez.entities.bullet.BulletManager;
import com.shockgamez.entities.player.Player;
import com.shockgamez.main.Game;
import com.shockgamez.states.State;

public class KeyInput implements KeyListener{

	private Game game;
	
	public KeyInput(Game game){
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_W)
			getPlayer().setVelY(-10);
		if(keycode == KeyEvent.VK_A)
			getPlayer().setVelX(-10);
		if(keycode == KeyEvent.VK_S)
			getPlayer().setVelY(10);
		if(keycode == KeyEvent.VK_D)
			getPlayer().setVelX(10);
		if(keycode == KeyEvent.VK_SPACE){
			if(getBulletManager().bullets.size() > 10)
				return;
			getBulletManager().addBullet(
				new Bullet(getPlayer().getX()+16, getPlayer().getY()));
		}
		if(keycode == KeyEvent.VK_P){
			Game.state = State.PAUSE;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		game.getGamestate().getPlayer().setVelX(0); 
		game.getGamestate().getPlayer().setVelY(0); 
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	private Player getPlayer(){
		return game.getGamestate().getPlayer();
	}
	private BulletManager getBulletManager(){
		return game.getGamestate().getBulletmanager();
	}
}
