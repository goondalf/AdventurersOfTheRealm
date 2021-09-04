package aotr.objects.entities;

import java.awt.image.BufferedImage;

import aotr.Main;

public class Beetle extends Entity {

	public Beetle(int ID, String name, BufferedImage sprite, Boolean isSolid, Main game) {
		super(ID, name, sprite, isSolid, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	void callAI() {
		this.move(game.rand.randBetween(1, -1), game.rand.randBetween(1, -1));
		
	}

	@Override
	void interact() {
		// TODO Auto-generated method stub
		
	}

}
