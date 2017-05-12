package com.shockgamez.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.shockgamez.main.Game;
import com.shockgamez.states.State;

public class MouseInput implements MouseListener {

	private Game game;

	public MouseInput(Game game) {
		this.game = game;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX(), y = e.getY();

		if (Game.state == State.MENU) {
			if (x >= game.getMenustate().getPlayX() && x <= game.getMenustate().getPlayX() + 200) {
				if (y >= game.getMenustate().getPlayY() && y <= game.getMenustate().getPlayY() + 100) {
					Game.state = State.GAME;
				}
			}
			if (x >= game.getMenustate().getExitX() && x <= game.getMenustate().getExitX() + 200) {
				if (y >= game.getMenustate().getExitY() && y <= game.getMenustate().getExitY() + 100) {
					System.exit(1);
				}
			}
		} else if (Game.state == State.PAUSE) {
			if (x >= game.getPausestate().getResumeX() && x <= game.getPausestate().getResumeX() + 300) {
				if (y >= game.getPausestate().getResumeY() && y < game.getPausestate().getResumeY() + 150) {
					Game.state = State.GAME;
				}
			}
			if (x >= game.getPausestate().getMenuX() && x <= game.getPausestate().getMenuX() + 300) {
				if (y >= game.getPausestate().getMenuY() && y <= game.getPausestate().getMenuY() + 150) {
					Game.state = State.MENU;
					game.getGamestate().reset();
				}
			}
		} else if (Game.state == State.GAMEOVER) {
			if (x >= game.getGameoverstate().getPlayAgainX() && x <= game.getGameoverstate().getPlayAgainX() + 300) {
				if (y >= game.getGameoverstate().getPlayAgainY()
						&& y <= game.getGameoverstate().getPlayAgainY() + 150) {
					Game.state = State.GAME;
				}
			}
			if (x >= game.getGameoverstate().getMenuX() && x <= game.getGameoverstate().getMenuX() + 300) {
				if (y >= game.getGameoverstate().getMenuY() && y <= game.getGameoverstate().getMenuY() + 150) {
					Game.state = State.MENU;
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

}
