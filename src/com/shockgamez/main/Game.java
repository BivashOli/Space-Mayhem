package com.shockgamez.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.shockgamez.input.KeyInput;
import com.shockgamez.input.MouseInput;
import com.shockgamez.states.GameOverState;
import com.shockgamez.states.GameState;
import com.shockgamez.states.MenuState;
import com.shockgamez.states.PauseState;
import com.shockgamez.states.State;

public class Game implements Runnable{

	private boolean running = false;

	private Thread thread;
	private BufferStrategy strategy;
	private Graphics g;
	
	public static State state;
	
	private MenuState menustate;
	private GameState gamestate;
	private PauseState pausestate;
	private GameOverState gameoverstate;
	
	private Display display;
	private MouseInput mouseinput;
	private KeyInput keyinput;
	
	
	public Game(){
		init();
		start();
	}
	
	private void init(){
		display = new Display();
		
		state = State.MENU;
		menustate = new MenuState();
		gamestate = new GameState();
		pausestate = new PauseState();
		gameoverstate = new GameOverState();
		
		mouseinput = new MouseInput(this);
		keyinput = new KeyInput(this);
		
		display.getCanvas().addMouseListener(mouseinput);
		display.getCanvas().addKeyListener(keyinput);
	}
	
	private void render(){
		strategy = display.getCanvas().getBufferStrategy();
		if(strategy == null){
			display.getCanvas().createBufferStrategy(3); 
			return;
		}
		g = strategy.getDrawGraphics();
		g.setColor(Color.BLACK); 
		g.fillRect(0, 0, display.getCanvas().getWidth(), display.getCanvas().getHeight()); 
		if(state == State.MENU)
			menustate.render(g); 
		if(state == State.GAME) 
			gamestate.render(g);
		if(state == State.PAUSE)
			pausestate.render(g); 
		if(state == State.GAMEOVER)
			gameoverstate.render(g); 
		strategy.show();
		g.dispose();
	}
	
	private void update(){
		if(state == State.GAME)
			gamestate.update();
	}
	

	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.exit(1); 
	}

	public void run() {
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public BufferStrategy getBs() {
		return strategy;
	}

	public void setBs(BufferStrategy bs) {
		this.strategy = bs;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
	public GameState getGamestate() {
		return gamestate;
	}

	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}

	public KeyInput getKeyinput() {
		return keyinput;
	}

	public void setKeyinput(KeyInput keyinput) {
		this.keyinput = keyinput;
	}

	public MenuState getMenustate() {
		return menustate;
	}

	public void setMenustate(MenuState menustate) {
		this.menustate = menustate;
	}

	public MouseInput getMouseinput() {
		return mouseinput;
	}

	public void setMouseinput(MouseInput mouseinput) {
		this.mouseinput = mouseinput;
	}

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		Game.state = state;
	}

	public GameOverState getGameoverstate() {
		return gameoverstate;
	}

	public void setGameoverstate(GameOverState gameoverstate) {
		this.gameoverstate = gameoverstate;
	}

	public PauseState getPausestate() {
		return pausestate;
	}

	public void setPausestate(PauseState pausestate) {
		this.pausestate = pausestate;
	}
	
}
