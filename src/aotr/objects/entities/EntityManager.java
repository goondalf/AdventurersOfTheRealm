package aotr.objects.entities;

import java.util.ArrayList;

import aotr.Main;

public class EntityManager {


private ArrayList<Entity> ActiveEntities;
private Main game;
private int[][] entityLayer;

	public EntityManager(Main game) {
	this.game = game;
	this.entityLayer = new int[game.getWorldWidth()][game.getWorldHeight()];
	for(int x = 0; x < game.getWorldWidth(); x++) {
		for(int y = 0; y < game.getWorldHeight(); y++) {
			this.entityLayer[x][y] = -1;
		}
	}
	
	this.ActiveEntities = new ArrayList<Entity>();
	}
	
	
	public void spawnEntity(int x, int y, int entityID) {
	
	Entity entity;

	
	entity = game.eIndex.getIndex(entityID);
	entity.setPos(x, y);
	
	this.ActiveEntities.add(entity);
	this.entityLayer[x][y] = ActiveEntities.size()-1;
		
	}
	
	
	public void callAI() {
	if(game.getGameState() == 1 && game.player.getPlayerState() == 0 && game.gameMenu == 0) {
		for(int i = 0;i < ActiveEntities.size();i++) {
			if(this.ActiveEntities.get(i) != null) {
				this.entityLayer[ActiveEntities.get(i).getX()][ActiveEntities.get(i).getY()] = -1;
				this.ActiveEntities.get(i).callAI();
				this.entityLayer[ActiveEntities.get(i).getX()][ActiveEntities.get(i).getY()] = i;
		}
		}
		
		
	}
		
			
	}
	
	
	public Entity getIndex(int i) {
		Entity entity;
		entity = this.ActiveEntities.get(i);
		return entity;
	}
	
	public Entity EntityAtPos(int x, int y) {
		Entity entity;
		entity = null;
		if(this.entityLayer[x][y] != -1) {
			entity = ActiveEntities.get(entityLayer[x][y]);
		}
		return entity;
	}
}
