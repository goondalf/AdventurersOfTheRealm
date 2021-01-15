package aotr.objects.player;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.Main;
import aotr.objects.Stats;
import aotr.resources.graphics.textureProcessor;

public class Player {
private int x;
private int y;
private Main game;
private int playerState;

private  BufferedImage tex;
private BufferedImage looktex;
private BufferedImage tAdjTex;
private textureProcessor pros;

public Look look;
public boolean lookbool;
public Stats stats;

	public Player(int x, int y, Main game, BufferedImage tex) {
	this.x = x;
	this.y = y;
	this.game = game;
	this.playerState = 0;
	this.stats = new Stats();
	
	lookbool = false;

	pros = new textureProcessor(tex);
	looktex = pros.grabImage(9, 6, 32, 32);
	Look look = new Look (pros.changeImageColor(looktex, Color.white,Color.RED),this, game);
	this.look = look;
	this.tex = pros.grabImage(1, 5, 32, 32);
	this.tAdjTex = pros.changeImageColor(pros.grabImage(15, 16, 32, 32), Color.white,Color.RED);
	}
	
	public void cancel() {
		this.playerState = 0;
	}
	
	
	public void move(int changeX, int changeY) {
		boolean solidBool = false;
		
		int finalX = changeX + this.x;
		int finalY = changeY + this.y;
		if (game.getGameState() == 1 && this.lookbool == false && game.gameMenu == 0 && this.playerState == 0) {
		
		if(((this.x + changeX) > -1) && ((this.x + changeX) < this.game.getWorld().worldWidth) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.getWorld().worldHeight)) {
			if( this.game.getWorld().getTile(this.x + changeX, this.y +changeY).getStructure() != null) {
				 solidBool = this.game.getWorld().getTile(this.x + changeX, this.y +changeY).getStructure().isSolid();
			}
			
			if( game.eManager.EntityAtPos(finalX, finalY) != null) {
				 solidBool = true;
			}
			if(solidBool == false){
		this.y = changeY + this.y;
		this.x = changeX + this.x;
		}
		}

		
	}else if(this.lookbool == true) {
		this.look.move(changeX, changeY);
	}
		
		
		if(this.playerState == 1 && ((this.x + changeX) > -1) && ((this.x + changeX) < this.game.getWorld().worldWidth) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.getWorld().worldHeight)) {
			interact(changeX,changeY);
		}
	}
	
	
	public void interact(int x, int y) {

		

		if(game.getWorld().getTile(this.x+x, this.y+y).getStructure() != null) {
			game.getWorld().getTile(this.x+x, this.y+y).getStructure().interact(game);
			this.playerState = 0;
	}
		
	this.playerState = 0;	
	}
	
	
	
	
	public void look() {

		if(lookbool == false) {
			lookbool = true;
			this.look.setX(this.x);
			this.look.setY(this.y);
		}else if(lookbool == true) {
			lookbool = false;
		}
			
		
		
	}
	
	
	
	
	
	public void setX(int x) {
		this.x = x;	
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;	
	}
	
	public BufferedImage getTex() {
		return this.tex;
		
	}
	
	public BufferedImage getTadjTex(){
		return this.tAdjTex;
	}

	public int getPlayerState() {
		return this.playerState;
	}
	
	public void setPlayerState(int var) {
		this.playerState = var;
	}
	
	
}
