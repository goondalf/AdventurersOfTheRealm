package aotr.objects.structures;

import java.awt.image.BufferedImage;

import aotr.Main;

public abstract class Structure {
protected String name;
protected BufferedImage texture;
protected Boolean collisionBool;
static Main game;
protected int x,y,z,ID,isclimeable;

	

	public  Structure(String name, int ID, BufferedImage texture, Boolean Solid, int climeable,Main game) {
	this.name = name;
	this.ID = ID;
	this.texture = texture;
	this.collisionBool = Solid;
	this.game = game;
	this.isclimeable = climeable;
	}

	

	
	
	public abstract void interact(); 
	
	
	
	
	
	public void replace(Structure structure) {
		this.ID = structure.ID;
		this.collisionBool = structure.collisionBool;
		this.name = structure.name;
		this.texture = structure.texture;
				
	}
	
	
	public void setPos(int x, int y, int z) {
		this.y = x;
		this.y = y;
		this.z = z;
	}
	
	
	
	
	public BufferedImage getTex() {
		return this.texture;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.ID;	
		
	}
	
	public Boolean isSolid() {
		return this.collisionBool;
		
	}
	
	public int getClimeable() {
	return this.isclimeable;	
	}	
		
}

