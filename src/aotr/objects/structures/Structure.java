package aotr.objects.structures;

import java.awt.image.BufferedImage;

import aotr.Main;

public class Structure {
private String name;
private int ID;
private BufferedImage texture;
private Boolean collisionBool;
	
	public Structure(String name, int ID, BufferedImage texture, Boolean Solid) {
	this.name = name;
	this.ID = ID;
	this.texture = texture;
	this.collisionBool = Solid;
	}

	

	
	
	public void interact(Main game) {
		
		int ID = this.ID;
		
		switch(ID) {
		case 6:
			replace(game.sIndex.getIndex(7));
			break;
		case 7:	
			replace(game.sIndex.getIndex(6));
			break;
		
		}
		
		
	}
	
	public void replace(Structure structure) {
		this.ID = structure.ID;
		this.collisionBool = structure.collisionBool;
		this.name = structure.name;
		this.texture = structure.texture;
	
				
		
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
	
}
