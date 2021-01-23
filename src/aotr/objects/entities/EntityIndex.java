package aotr.objects.entities;


import java.util.ArrayList;

import aotr.Main;


public class EntityIndex {
	private ArrayList<Entity> entIndex = new ArrayList<Entity>();
	private Entity entity;
	private Main game;
	
	public EntityIndex(Main game) {
	this.game = game;	
		
		
		for(int i = 0; i < 10; i++) {
			switch(i) {
			case 0:
				entity = new Entity(i,"debug",game.tManager.getImage(2, 2, 0),game);
			break;
			
			
			}
			entIndex.add(entity);
		}
		}
	

	public Entity getIndex(int i) {
		Entity ent = new Entity(this.entIndex.get(i).getID(),this.entIndex.get(i).getName(),this.entIndex.get(i).getTex(),game);
		return ent;
	}

}

