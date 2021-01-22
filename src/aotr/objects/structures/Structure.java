package aotr.objects.structures;

import java.awt.image.BufferedImage;

import aotr.Main;

public class Structure {
private String name;
private int ID;
private BufferedImage texture;
private Boolean collisionBool;
private Main game;
	public Structure(String name, int ID, BufferedImage texture, Boolean Solid, Main game) {
	this.name = name;
	this.ID = ID;
	this.texture = texture;
	this.collisionBool = Solid;
	this.game = game;
	}

	

	
	
	public void interact() {
		
		int ID = this.ID;
		
		switch(ID) {
		case 13:
			replace(game.sIndex.getIndex(14));
			break;
		case 14:	
			replace(game.sIndex.getIndex(13));
			break;
		
		}	
	}
	
	
	public void wallConnect() {
		
		
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
