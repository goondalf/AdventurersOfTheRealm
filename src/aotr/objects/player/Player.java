package aotr.objects.player;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.Main;
import aotr.resources.graphics.textureProcessor;

public class Player {
private int x;
private int y;
private Main game;
private  BufferedImage tex;
private BufferedImage looktex;
private textureProcessor pros;
public Look look;
public boolean lookbool;

	public Player(int x, int y, Main game, BufferedImage tex) {
	this.x = x;
	this.y = y;
	this.game = game;
	lookbool = false;

	pros = new textureProcessor(tex);
	looktex = pros.grabImage(9, 6, 32, 32);
	Look look = new Look (pros.changeImageColor(looktex, Color.white,Color.RED),this, game);
	this.look = look;
	this.tex = pros.grabImage(1, 5, 32, 32);
		
	}
	
	
	
	public void move(int changeX, int changeY) {

		if (game.getGameState() == 1 && this.lookbool == false && this.game.getWorld().getTile(this.x + changeX, this.y +changeY).getStructure() == null) {
		if(((this.x + changeX) > -1) && ((this.x + changeX) < 100)) {
		this.x = changeX + this.x;
		}
		if(((this.y + changeY) > -1) && ((this.y + changeY) < 100)) {
		this.y = changeY + this.y;
		}
		
	}else if(this.lookbool == true) {
		this.look.move(changeX, changeY);
		
	}
		
		
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
	

	
	
}
