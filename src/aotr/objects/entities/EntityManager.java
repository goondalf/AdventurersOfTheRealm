package aotr.objects.entities;

import java.util.ArrayList;

import aotr.Main;
import aotr.world.world;

public class EntityManager {

private ArrayList<Entity> ActiveEntities;
private Main game;


	public EntityManager(Main game) {
	this.game = game;
	this.ActiveEntities = new ArrayList<Entity>();
	}
	
	
	private Entity createEntity(int id) {
		Entity entity = null;
		switch(id) {
		case 0:
			entity = new Beetle(id,"debug",game.tManager.getImage(2, 2, 0),true,game);
		break;
		     
		
		}
		return entity;
	}
	
	
	public void spawnEntity(int x, int y,int z, int entityID) {
	
	Entity entity;

	
	entity = createEntity(entityID);
	entity.setPos(x, y,z);
	
	this.ActiveEntities.add(entity);
	world.setEntity(x,y,z,entity); 
		
	}
	
	
	public void callAI() {
	if(game.getGameState() == 1 && game.player.getPlayerState() == 0 && game.gameMenu == 0) {
		for(int i = 0;i < ActiveEntities.size();i++) {
			if(this.ActiveEntities.get(i) != null) {
				world.setEntity(ActiveEntities.get(i).getX(),ActiveEntities.get(i).getY(),ActiveEntities.get(i).getZ(),null);
				this.ActiveEntities.get(i).callAI();
				world.setEntity(ActiveEntities.get(i).getX(),ActiveEntities.get(i).getY(),ActiveEntities.get(i).getZ(),this.ActiveEntities.get(i)); 
		}
		}
		
		
	}
		
			
	}
	
	
	public Entity getIndex(int i) {
		Entity entity;
		entity = this.ActiveEntities.get(i);
		return entity;
	}
	
	public Entity EntityAtPos(int x, int y,int z) {
		
		return game.world.getTile(x, y, z).getEntity();
	}
	
	
	
}
