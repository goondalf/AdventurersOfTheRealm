package aotr.objects.entities;

import java.awt.image.BufferedImage;

import aotr.Main;

public abstract class Entity {
private int x,y,z,ID;
private BufferedImage sprite;
private String name;
static Main game;
private boolean solid;

	public Entity(int ID, String name, BufferedImage sprite,Boolean isSolid, Main game){
		this.sprite = sprite;
		this.name = name;
		this.ID = ID;
		Entity.game = game;
		this.solid = isSolid;
	}
	
	
	
	abstract void callAI();
	abstract void interact();
	
	public void setPos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public void move(int changeX, int changeY) {
		
		
		int finalX = changeX + this.x;
		int finalY = changeY + this.y;
		if(((this.x + changeX) > -1) && ((this.x + changeX) < this.game.world.getWidth()) && ((this.y + changeY) > -1) && ((this.y + changeY) < this.game.world.getHeight())) {
			
			if(game.world.isTileSolid(finalX, finalY, this.z) == false){
		this.y = changeY + this.y;
		this.x = changeX + this.x;
			}
		}		
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
		
	public boolean isSolid() {
		return solid;
	}
}
