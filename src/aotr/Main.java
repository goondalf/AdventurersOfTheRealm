package aotr;

import java.awt.Canvas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import aotr.objects.entities.EntityManager;
import aotr.objects.entities.EntityIndex;
import aotr.objects.floors.Floor;
import aotr.objects.floors.FloorIndex;
import aotr.objects.player.Player;
import aotr.objects.structures.StructureIndex;
import aotr.objects.structures.StructureManager;
import aotr.renderer.LoadingScreen;
import aotr.renderer.MainMenu;
import aotr.renderer.Settings;
import aotr.renderer.gameSpace;
import aotr.renderer.InGame.ActionMenu;
import aotr.renderer.InGame.HUD;
import aotr.renderer.InGame.PauseMenu;
import aotr.resources.graphics.textureManager;
import aotr.system.keyInput;
import aotr.world.world;




public class Main extends Canvas implements Runnable{

	
	public static int WIDTH =320;
	public static int HEIGHT = 320;
	public static final int SCALE = 2;
	public final static String TITLE = "Adventurers of the Realm";
	
	private boolean running = false;
	public Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	
	
	//index
	public FloorIndex fIndex;
	public StructureIndex sIndex;
	public EntityIndex eIndex;
	public EntityManager eManager;
	public textureManager tManager;
	public StructureManager sManager;
	
	//game objects
	private MainMenu mm;
	public gameSpace tiles;
	public world gameWorld;
	public Player player;
	public HUD gameHud;
	public PauseMenu pauseMenu;
	public ActionMenu actionMenu;
	public LoadingScreen loadscreen;
	public Settings settings;
	public JFrame frame;
	//game variables
	public int gamestate;
	public int gameMenu;
	public boolean haltRender = false;
	private BufferedImage sheet;
	
	public boolean fullscreen;
	
	private int worldWidth = 10000;
	private int worldHeight = 10000;
	
	public static GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static GraphicsDevice device = graphics.getDefaultScreenDevice();
	 
	
	public void init() {
		this.gamestate = 10;
	tManager = new textureManager(this);
	try {
		tManager.loadImage("default/ascii.png");
		tManager.loadImage("default/AOTRfloors.png");
		tManager.loadImage("default/AOTRentities.png");
		tManager.loadImage("default/AOTRwalls.png");
		tManager.loadImage("default/AOTRstructures.png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	gameMenu = 0;
	fIndex = new FloorIndex(this);
	sIndex = new StructureIndex(this);
	eIndex = new EntityIndex(this);
	eManager = new EntityManager(this);
	sManager = new StructureManager(this);
	
	settings = new Settings(this);
	mm = new MainMenu(this);
	gameWorld = new world(this,worldWidth, worldHeight);
	tiles = new gameSpace(this);
	gameHud = new HUD(this);
	player = new Player(50,50,this);
	pauseMenu = new PauseMenu(this);
	actionMenu = new ActionMenu(this);
	
	System.gc();
	this.gamestate = 0;
	
	}
	
	
	private synchronized void start(JFrame frame) {
		this.frame = frame;
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
		loadscreen = new LoadingScreen();
		
		
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
				if(haltRender == false) {
				render();
				}
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
		    if(this.gameMenu == 1) {
				pauseMenu.Render(g, getWidth(), getHeight());
			}else if(this.gameMenu == 2) {
				actionMenu.Render(g, getWidth(), getHeight());
			}
		}else if(gamestate == 10) {
			loadscreen.render(g, getWidth(), getHeight());
			
		}else if(gamestate == 2) {
			settings.render(g,getWidth(),getHeight());
		}
		
		
		
		g.dispose();
		bs.show();
		
		}
		
		
	
	

	
	
	public static void main(String args[]) {

		
		Main game = new Main();
		game.haltRender = true;
		game.fullscreen = false;
		
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.addKeyListener(new keyInput(game));
		
		game.buildFrame(game);
		
		
		game.haltRender = false;
		game.init();
		
	}

	
	
	public void buildFrame(Main game) {
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		game.start(frame);
		frame.pack();
		
		frame.setVisible(true);
		
		
	}
	
	public void cancel() {
	player.cancel();
	if(this.gameMenu == 2) {
		this.gameMenu= 0;
	}
	}
	
	public void toggleFullScreen() {
		if(gamestate != 10) {
		if(fullscreen == false) {
		device.setFullScreenWindow(this.frame);
		fullscreen = true;
		}else {
			device.setFullScreenWindow(null);
			fullscreen = false;
		}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			player.move(1, 0);
		}
		if(key == KeyEvent.VK_LEFT){
			player.move(-1, 0);	
		}
		if(key == KeyEvent.VK_UP) {
		mm.menuScrollUp();	
		player.move(0, -1);
		pauseMenu.scroll(-1);
		actionMenu.scroll(-1);
		settings.menuScrollUp();
		}
		if(key == KeyEvent.VK_DOWN) {
		mm.menuScrollDown();
		player.move(0, 1);
		pauseMenu.scroll(1);
		actionMenu.scroll(1);
		settings.menuScrollDown();
		}
	
		if(key == KeyEvent.VK_ENTER) {
		mm.select();
		actionMenu.select();
		settings.select();
		pauseMenu.select();
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
		
		if (key == KeyEvent.VK_ESCAPE) {
		pauseMenu.toggle();
		cancel();
		
		}
		
		if (key == KeyEvent.VK_SPACE) {
			actionMenu.toggle();
			}
		
		if(key == KeyEvent.VK_B) {
			
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
		this.eManager.callAI();	
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
	
	public int getWorldWidth() {
		return this.worldWidth;
	}
	
	public int getWorldHeight() {
		return this.worldWidth;
	}
}


