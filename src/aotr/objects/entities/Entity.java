package aotr.objects.entities;

import java.awt.image.BufferedImage;



public class Entity {

	private BufferedImage sprite;
	private String name;
	private int ID;
	
	public Entity(int ID, String name, BufferedImage sprite) {
		this.sprite = sprite;
		this.name = name;
		this.ID = ID;
		
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
}
