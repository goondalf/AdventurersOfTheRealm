package aotr.objects.entities;

import java.util.ArrayList;

import aotr.Main;

public class EntityManager {


private ArrayList<Entity> ActiveEntity;
private Main game;
	

	public EntityManager(Main game) {
	this.game = game;

	this.ActiveEntity = new ArrayList<Entity>();
	}
	
	
	public void spawnEntity(int x, int y, int entityID) {
	
	Entity entity;

	
	entity = game.eIndex.getIndex(entityID);
	entity.setPos(x, y);
	
	this.ActiveEntity.add(entity);

		
	}
	
	
	public void callAI() {
	if(game.getGameState() == 1 && game.player.getPlayerState() == 0 && game.gameMenu == 0) {
		for(int i = 0;i < ActiveEntity.size();i++) {
			if(this.ActiveEntity.get(i) != null) {
				this.ActiveEntity.get(i).callAI();
		}
		}
		
		
	}
		
			
	}
	
	
	public Entity getIndex(int i) {
		Entity entity;
		entity = this.ActiveEntity.get(i);
		return entity;
	}
	
	public Entity EntityAtPos(int x, int y) {
		Entity entity;
		entity = null;
		for(int i = 0; i < this.ActiveEntity.size();i++) {
			if(this.ActiveEntity.get(i) != null) {
			if(this.ActiveEntity.get(i).getX() == x && this.ActiveEntity.get(i).getY() == y) {
				entity = this.ActiveEntity.get(i);
			}
			}
		}
		return entity;
	}
}
