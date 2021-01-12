package aotr.objects.entities;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.objects.floors.Floor;
import aotr.resources.graphics.textureProcessor;

public class EntityIndex {
	private Entity[] entIndex = new Entity[10];
	private textureProcessor texP;
	private Entity entity;
	
	public EntityIndex(BufferedImage sheet) {
		
		
		texP = new textureProcessor(sheet);
		for(int i = 0; i < 10; i++) {
			switch(i) {
			case 0:
				entity = new Entity(i,"debug",texP.changeImageColor(texP.grabImage(1, 1, 32, 32), Color.white, Color.red));
				entIndex[i] = entity;
				break;
			}
			
		}
		}
	

	public Entity getIndex(int i) {
		Entity ent = new Entity(this.entIndex[i].getID(),this.entIndex[i].getName(),this.entIndex[i].getTex());
		return this.entIndex[i];
	}

}

