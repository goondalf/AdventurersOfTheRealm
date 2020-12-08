package aotr.objects.types;

import java.awt.image.BufferedImage;

import aotr.Main;
import aotr.resources.graphics.textureProcessor;

public class Player {
private int x;
private int y;
private Main game;
private  BufferedImage tex;
private textureProcessor pros;

	public Player(int x, int y, Main game, BufferedImage tex) {
	this.x = x;
	this.y = y;
	this.game = game;
	
	pros = new textureProcessor(tex);
	this.tex = pros.grabImage(1, 5, 32, 32);
		
	}
	
	
	
	public void move(int changeX, int changeY) {
	if (game.getGameState() == 1) {
		if(((this.x + changeX) > -1) && ((this.x + changeX) < 100)) {
		this.x = changeX + this.x;
		}
		if(((this.y + changeY) > -1) && ((this.y + changeY) < 100)) {
		this.y = changeY + this.y;
		}
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
