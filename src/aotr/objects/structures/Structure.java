package aotr.objects.structures;

import java.awt.image.BufferedImage;

import aotr.Main;

public class Structure {
private String name;
private int ID;
private BufferedImage texture;
private Boolean collisionBool;
private Main game;
private int x;
private int y;
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
		case 0:
			if(this.collisionBool == true) {
				this.collisionBool = false;
				this.texture = (game.tManager.getImage(4,1,0));
			}else if(this.collisionBool == false) {
				this.collisionBool = true;
				this.texture = (game.tManager.getImage(4,0,0));
		break;
			}
		}	
	}
	
	
	
	
	
	public void replace(Structure structure) {
		this.ID = structure.ID;
		this.collisionBool = structure.collisionBool;
		this.name = structure.name;
		this.texture = structure.texture;
				
	}
	
	
	public void setPos(int x, int y) {
		this.y = x;
		this.y = y;
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
