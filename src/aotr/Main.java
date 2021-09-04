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
import aotr.objects.floors.FloorIndex;
import aotr.objects.player.Player;
import aotr.objects.structures.StructureManager;
import aotr.renderer.GenerateWorldMenu;
import aotr.renderer.LoadingScreen;
import aotr.renderer.MainMenu;
import aotr.renderer.Settings;
import aotr.renderer.gameSpace;
import aotr.renderer.InGame.ActionMenu;
import aotr.renderer.InGame.HUD;
import aotr.renderer.InGame.PauseMenu;
import aotr.resources.graphics.textureManager;
import aotr.system.keyInput;
import aotr.system.randGenerator;
import aotr.world.world;




public class Main extends Canvas implements Runnable{

	
	public static int WIDTH =320;
	public static int HEIGHT = 320;
	public static final int SCALE = 2;
	public final static String TITLE = "Adventurers of the Realm";
	
	private boolean running = false;
	public Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	private int key;
	
	//index
	public FloorIndex fIndex;
	public EntityManager eManager;
	public textureManager tManager;
	public StructureManager sManager;
	
	//game objects
	private MainMenu mm;
	public gameSpace tiles;
	public world world;
	public Player player;
	public HUD gameHud;
	public PauseMenu pauseMenu;
	public ActionMenu actionMenu;
	public LoadingScreen loadscreen;
	public Settings settings;
	public JFrame frame;
	public GenerateWorldMenu genMenu;
	public randGenerator rand;
	
	//game variables
	public int gamestate;
	public int gameMenu;
	public boolean haltRender = false;

	
	public boolean fullscreen;
	
	private int worldWidth = 300;
	private int worldHeight = 300;
	private int worldDepth = 4;
	
	public static GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static GraphicsDevice device = graphics.getDefaultScreenDevice();
	 
	
	public void init() {
		this.gamestate = 10;
	tManager = new textureManager(this);
	try {
		tManager.loadImage("default/AOTRascii.png");
		tManager.loadImage("default/AOTRfloors.png");
		tManager.loadImage("default/AOTRentities.png");
		tManager.loadImage("default/AOTRwalls.png");
		tManager.loadImage("default/AOTRstructures.png");
		tManager.loadImage("default/AOTRmisc.png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	rand = new randGenerator(this);
	gameMenu = 0;
	fIndex = new FloorIndex(this);
	eManager = new EntityManager(this);
	sManager = new StructureManager(this);
	
	
	genMenu = new GenerateWorldMenu(this);
	settings = new Settings(this);
	mm = new MainMenu(this);
	tiles = new gameSpace(this);
	gameHud = new HUD(this);
	player = new Player(50,50,this);
	pauseMenu = new PauseMenu(this);
	actionMenu = new ActionMenu(this);
	
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
		genMenu.menuScrollUp();
		}
		if(key == KeyEvent.VK_DOWN) {
		mm.menuScrollDown();
		player.move(0, 1);
		pauseMenu.scroll(1);
		actionMenu.scroll(1);
		settings.menuScrollDown();
		genMenu.menuScrollDown();
		}
	
		if(key == KeyEvent.VK_ENTER) {
		mm.select();
		actionMenu.select();
		settings.select();
		pauseMenu.select();
		genMenu.select();
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
			player.changeZ(1);
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
		
		if(key == KeyEvent.VK_I) {
		this.toggleHud();
		}
		
		key = 0;
		
		
		
	
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
		    tiles.render(g, getWidth(), getHeight());
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
		}else if(gamestate == 3) {
			genMenu.render(g, getWidth(), getHeight());
		}
		
		
		
		g.dispose();
		bs.show();
		
		}
		
		
	
	

	
	
	public static void main(String args[]) {

		
		
		Main game = new Main();
		game.init();
		game.haltRender = true;
		game.fullscreen = false;
		
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.addKeyListener(new keyInput(game));
		
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
		
		
		game.haltRender = false;
		
		
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
		 key = e.getKeyCode();
		
	
	}
	
	public void exit() {
		System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		
		
	}
	

	
	public int getGameState() {
		return this.gamestate;
		
	}
	



	public void generateWorld() {
		gamestate = 10;
		world = new world(this,worldWidth, worldHeight,worldDepth);
		this.world.generateWorld();
	}

	public void toggleHud() {
		if(gamestate == 1) {
			this.gameHud.hudVisibility = !this.gameHud.hudVisibility;
		}
	}
	
	
	public int getWorldWidth() {
		
		return this.worldWidth;
	}
	
	public int getWorldHeight() {
		return this.worldWidth;
	}
	
	public int getWorldDepth() {
		return this.worldDepth;
	}
}


