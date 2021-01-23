package aotr.objects.player;


import java.awt.image.BufferedImage;

import aotr.Main;
import aotr.objects.Stats;


public class Player {
private int x;
private int y;
private Main game;
private int playerState;

private  BufferedImage tex;
private BufferedImage tAdjTex;
public Look look;
public Stats stats;

	public Player(int x, int y, Main game) {
	this.x = x;
	this.y = y;
	this.game = game;
	this.playerState = 0;
	this.stats = new Stats();
	
	

	
	this.look = new Look (game.tManager.getImage(0, 8, 5), game);
	
	
	this.tex = game.tManager.getImage(0, 0, 4);
	this.tAdjTex = (game.tManager.getImage(0, 14, 15));
	}
	
	public void cancel() {
		this.playerState = 0;
	}
	
	
	public void move(int changeX, int changeY) {
		boolean solidBool = false;
		
		int finalX = changeX + this.x;
		int finalY = changeY + this.y;
		if (game.getGameState() == 1 && playerState == 0 && game.gameMenu == 0 && this.playerState == 0) {
		
		if(((this.x + changeX) > -1) && ((this.x + changeX) < this.game.getWorld().getWidth()) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.getWorld().getHeight())) {
			if( game.gameWorld.getStructure(finalX, finalY) != null) {
				 solidBool = game.gameWorld.getStructure(finalX, finalY).isSolid();
			}
			
			if( game.eManager.EntityAtPos(finalX, finalY) != null) {
				 solidBool = true;
			}
			if(solidBool == false){
		this.y = changeY + this.y;
		this.x = changeX + this.x;
		}
		}

		
	}else if(playerState == 2) {
		this.look.move(changeX, changeY);
	}
		
		
		if(this.playerState == 1 && ((this.x + changeX) > -1) && ((this.x + changeX) < this.game.getWorld().getWidth()) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.getWorld().getHeight())) {
			interact(changeX,changeY);
		}
	}
	
	
	public void interact(int x, int y) {

		

		if(game.gameWorld.getStructure(this.x+x, this.y+y) != null) {
			game.gameWorld.getStructure(this.x+x, this.y+y).interact();
			this.playerState = 0;
	}
		
	this.playerState = 0;	
	}
	
	
	
	
	public void look() {

		if(playerState == 0) {
			playerState = 2;
			this.look.setX(this.x);
			this.look.setY(this.y);
		}else if(playerState == 2) {
			playerState = 0;
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
