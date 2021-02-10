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
	
	
	public void spawnEntity(int x, int y,int z, int entityID) {
	
	Entity entity;

	
	entity = game.eIndex.getIndex(entityID);
	entity.setPos(x, y,z);
	
	this.ActiveEntities.add(entity);
	game.gameWorld.getTile(x, y, z).setEntity(ActiveEntities.size() - 1);; 
		
	}
	
	
	public void callAI() {
	Entity entity;
		if(game.getGameState() == 1 && game.player.getPlayerState() == 0 && game.gameMenu == 0) {
		for(int i = 0;i < ActiveEntities.size();i++) {
			if(this.ActiveEntities.get(i) != null) {
				entity = ActiveEntities.get(i);
				game.gameWorld.getTile(entity.getX(),entity.getY(),entity.getZ()).setEntity(-1);
				this.ActiveEntities.get(i).callAI();
				game.gameWorld.getTile(entity.getX(),entity.getY(),entity.getZ()).setEntity(i); 
		}
		}
		
		
	}
		
			
	}
	
	
	public Entity getIndex(int i) {
		Entity entity;
		entity = this.ActiveEntities.get(i);
		return entity;
	}
	

}
