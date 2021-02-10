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
<<<<<<< HEAD
	game.gameWorld.getTile(x, y, z).setEntity(ActiveEntities.size() - 1);; 
=======
	this.entityLayer[x][y] = ActiveEntities.size()-1;
>>>>>>> parent of a8470dc (3d)
		
	}
	
	
	public void callAI() {
	Entity entity;
		if(game.getGameState() == 1 && game.player.getPlayerState() == 0 && game.gameMenu == 0) {
		for(int i = 0;i < ActiveEntities.size();i++) {
			if(this.ActiveEntities.get(i) != null) {
<<<<<<< HEAD
				entity = ActiveEntities.get(i);
				game.gameWorld.getTile(entity.getX(),entity.getY(),entity.getZ()).setEntity(-1);
				this.ActiveEntities.get(i).callAI();
				game.gameWorld.getTile(entity.getX(),entity.getY(),entity.getZ()).setEntity(i); 
=======
				this.entityLayer[ActiveEntities.get(i).getX()][ActiveEntities.get(i).getY()] = -1;
				this.ActiveEntities.get(i).callAI();
				this.entityLayer[ActiveEntities.get(i).getX()][ActiveEntities.get(i).getY()] = i;
>>>>>>> parent of a8470dc (3d)
		}
		}
		
		
	}
		
			
	}
	
	
	public Entity getIndex(int i) {
		Entity entity;
		entity = this.ActiveEntities.get(i);
		return entity;
	}
	
<<<<<<< HEAD

=======
	public Entity EntityAtPos(int x, int y) {
		Entity entity;
		entity = null;
		if(this.entityLayer[x][y] != -1) {
			entity = ActiveEntities.get(entityLayer[x][y]);
		}
		return entity;
	}
>>>>>>> parent of a8470dc (3d)
}
