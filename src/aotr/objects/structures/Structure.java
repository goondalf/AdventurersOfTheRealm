package aotr.objects.structures;

import java.awt.image.BufferedImage;

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

	
	
	public BufferedImage getTex() {
		return this.texture;
	}
	
	
	public Boolean isSolid() {
		return this.collisionBool;
		
	}
}
