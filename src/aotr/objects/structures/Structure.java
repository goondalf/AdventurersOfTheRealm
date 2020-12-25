package aotr.objects.structures;

import java.awt.image.BufferedImage;

public class Structure {
private String name;
private int ID;
private BufferedImage texture;
	
	public Structure(String name, int ID, BufferedImage texture) {
	this.name = name;
	this.ID = ID;
	this.texture = texture;
	}

	
	
	public BufferedImage getTex() {
		return this.texture;
	}
	
}
