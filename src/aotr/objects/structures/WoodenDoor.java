package aotr.objects.structures;

import java.awt.image.BufferedImage;

import aotr.Main;

public class WoodenDoor extends Structure {

	public WoodenDoor(String name, int ID, BufferedImage texture, Boolean Solid, int climeable, Main game) {
		super(name, ID, texture, Solid, climeable, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact() {
		if(this.collisionBool == true) {
			this.collisionBool = false;
			this.texture = (game.tManager.getImage(4,1,0));
		}else if(this.collisionBool == false) {
			this.collisionBool = true;
			this.texture = (game.tManager.getImage(4,0,0));
		
	}	
	}
	
	
	
	
	
}
