package aotr.objects.floors;

import java.awt.image.BufferedImage;

public class Floor {

private BufferedImage texture;
private String name;
	
 public Floor(BufferedImage texture, String floorname) {	
	 this.texture = texture;
	 this.name = floorname;
	 
	 
	 
 }
 
 public BufferedImage getTex() {
	 return this.texture;
	 
 }
 
}
