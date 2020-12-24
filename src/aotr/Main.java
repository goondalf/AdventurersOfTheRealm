package aotr;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import aotr.objects.floors.Floor;
import aotr.objects.floors.FloorIndex;
import aotr.objects.player.Player;
import aotr.renderer.HUD;
import aotr.renderer.MainMenu;
import aotr.renderer.gameSpace;
import aotr.resources.graphics.textureLoader;
import aotr.system.keyInput;
import aotr.world.world;




public class Main extends Canvas implements Runnable{

	public static int WIDTH =320;
	public static int HEIGHT = 320;
	public static final int SCALE = 2;
	public final static String TITLE = "Adventurers of the Realm";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	//game objects
	private MainMenu mm;
	public gameSpace tiles;
	public FloorIndex fIndex;
	private world gameWorld;
	public Player player;
	public HUD gameHud;
	
	//game variables
	private int gamestate;
	
	private BufferedImage sheet;
	textureLoader texLoader = new textureLoader();
	
	public void init() {
		
		
	try {
		this.sheet = texLoader.loadImage("default/ascii.png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	this.fIndex = new FloorIndex(sheet);
	mm = new MainMenu(this);
	gameWorld = new world(this);
	tiles = new gameSpace(this);
	gameHud = new HUD(this);
	player = new Player(50,50,this,sheet);
	
	
	}
	
	
	private synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	
	
	
	private synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
		
	}
	
	
	
	
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				updates++;
				delta--;
				frames++;
				render();
			}
			;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + "ticks, fps " + frames);
				updates = 0;
				frames = 0;
			}		
		}
		stop();
	}

	

	
	
	
	
	
	private void tick() {
		this.requestFocus();
		
		
	}

	private void render() {

		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		
		if(gamestate == 0) {
			mm.render(g, getWidth(), getHeight());
		}else if(gamestate == 1) {
		    tiles.render(g, getWidth(), getHeight(), this);
		    gameHud.render(g, getWidth(), getHeight(), this);
		}
		
		
		g.dispose();
		bs.show();
		
		
		
	}
	
	public static void main(String args[]) {
		Main game = new Main();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.addKeyListener(new keyInput(game));
		JFrame frame = new JFrame(Main.TITLE);
		//frame.addKeyListener(new keyInput(game));
		frame.setFocusable(true);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocus();
		game.start();
		
	
		
	}


	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			player.move(1, 0);
		}else if(key == KeyEvent.VK_LEFT){
			player.move(-1, 0);	
		}else if(key == KeyEvent.VK_UP) {
		mm.menuScrollUp();	
		player.move(0, -1);
		}else if(key == KeyEvent.VK_DOWN) {
		mm.menuScrollDown();
		player.move(0, 1);
		}
	
		if(key == KeyEvent.VK_ENTER) {
		mm.select();	
		}
		if(key == KeyEvent.VK_K) {
		tiles.zoomIn();
		}
		if(key == KeyEvent.VK_L) {
			tiles.zoomOut();	
		}
		
		
		if(key == KeyEvent.VK_M) {
		player.look();
			
			
		}
		
		//*******************
		// movement controls
		//*******************
	if(key == KeyEvent.VK_Q) {
		player.move(-1, -1);	

	}
		if(key == KeyEvent.VK_W) {
			player.move(0, -1);
			
		}
		if(key == KeyEvent.VK_E) {
			player.move(1, -1);
			
		}
		if(key == KeyEvent.VK_A) {
			player.move(-1, 0);
			
		}
		if(key == KeyEvent.VK_S) {
			
		}
		if(key == KeyEvent.VK_D) {
			player.move(1, 0);

		}
		if(key == KeyEvent.VK_Z) {
			player.move(-1, 1);
			
		}
		if(key == KeyEvent.VK_X) {
			player.move(0, 1);
			
		}
		if(key == KeyEvent.VK_C) {
			player.move(1, 1);
			
		}
		
		

	}
	
	public void exit() {
		System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setGameState(int input) {
		this.gamestate = input;
		
	}
	
	public int getGameState() {
		return this.gamestate;
		
	}
	
	public BufferedImage getSheet() {
		return this.sheet;
		
	}
	
	public Floor getFloor(int i) {
		return fIndex.getIndex(i);
	}
	
	public world getWorld() {
		return this.gameWorld;
	}
	
	public void generateWorld() {
		this.gameWorld.generateWorld();
	}
	
	public BufferedImage getPlayerTex() {
		return player.getTex();
		
	}
	
	public int getPlayerX() {
		return player.getX();	
	}
	public int getPlayerY() {
		return player.getY();	
	}
}
