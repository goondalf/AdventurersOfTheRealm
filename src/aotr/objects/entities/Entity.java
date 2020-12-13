package aotr.objects.entities;

import java.awt.image.BufferedImage;



public class Entity {

	private BufferedImage sprite;
	private String name;

	public Entity(String name, BufferedImage sprite) {
		this.sprite = sprite;
		this.name = name;
		
		
	}
	
}
