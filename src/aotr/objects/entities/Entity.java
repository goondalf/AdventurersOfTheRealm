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
	private int z;
	private Main game;
	public Stats stats;
	private boolean solid;

	public Entity(int ID, String name, BufferedImage sprite,Boolean isSolid, Main game) {
		this.sprite = sprite;
		this.name = name;
		this.ID = ID;
		this.game = game;
		this.stats = new Stats();
		this.solid = isSolid;
	}
	
	
	public void callAI() {
		switch(this.ID) {
		case 0:
			this.debugAI();
			break;
		
		}
	}
	
	
	
	public void move(int changeX, int changeY) {
	
	
		int finalX = changeX + this.x;
		int finalY = changeY + this.y;
		if(((this.x + changeX) > -1) && ((this.x + changeX) < this.game.getWorld().getWidth()) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.getWorld().getHeight())) {
			
			if(game.world.isTileSolid(finalX, finalY, this.z) == false){
		this.y = changeY + this.y;
		this.x = changeX + this.x;
			}
		}		
	}
	
	public boolean isSolid() {
		return this.solid;
	}
	
	
	public void setPos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getZ() {
		return this.z;
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
		this.move(game.rand.randBetween(1, -1), game.rand.randBetween(1, -1));
	}
	
	

}
