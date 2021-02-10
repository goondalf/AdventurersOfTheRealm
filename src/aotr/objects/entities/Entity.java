package aotr.objects.entities;

import java.awt.image.BufferedImage;
import java.util.Random;

import aotr.Main;
import aotr.objects.Stats;



public class Entity {

	private BufferedImage sprite;
	private String name;
	private int ID;
	private int x;
	private int y;
	private Main game;
	public Stats stats;
	
	public Entity(int ID, String name, BufferedImage sprite, Main game) {
		this.sprite = sprite;
		this.name = name;
		this.ID = ID;
		this.game = game;
		this.stats = new Stats();
	}
	
	
	public void callAI() {
		switch(this.ID) {
		case 0:
			this.debugAI();
			break;
		
		}
	}
	
	
	
	public void move(int changeX, int changeY) {
		boolean solidBool = false;
	
		int finalX = changeX + this.x;
		int finalY = changeY + this.y;
		if(((this.x + changeX) > -1) && ((this.x + changeX) < this.game.getWorld().getWidth()) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.getWorld().getHeight())) {
			if( game.gameWorld.getStructure(finalX, finalY) != null) {
				 solidBool = game.gameWorld.getStructure(finalX, finalY).isSolid();
			}
			
		if(game.player.getX() == finalX && game.player.getY() == finalY) {
			solidBool = true;
<<<<<<< HEAD
		}else if(game.gameWorld.getEntity(finalX, finalY,z) != null) {
=======
		}else if(game.eManager.EntityAtPos(finalX, finalY) != null) {
>>>>>>> parent of a8470dc (3d)
			solidBool = true;
		}
			
			if(solidBool == false){
		this.y = changeY + this.y;
		this.x = changeX + this.x;
			}
		}		
	}
	

	
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	public int getID() {
	return this.ID;	
	}
	
	public String getName() {
	return this.name;
	}
	
	public BufferedImage getTex() {
		return this.sprite;
	}
	
	
	private void debugAI() {
		this.move(this.randBetween(1, -1), this.randBetween(1, -1));
	}
	
	
	private int randBetween(int upper, int lower) {
		Random r = new Random();
		int num = r.nextInt((upper - lower)+1) + lower;
		return num;
	}
	
}
