package aotr.objects.entities;

import aotr.Main;

public class EntityManager {

private Entity[] ActiveEntityIndex;
private int maxEntities;
private Main game;
	

	public EntityManager(Main game) {
	this.game = game;
	this.maxEntities = 100;	
	this.ActiveEntityIndex = new Entity[maxEntities];

	}
	
	
	public void spawnEntity(int x, int y, int entityID) {
	
	Entity entity;
	int i = 0;
	
	entity = game.eIndex.getIndex(entityID);
	entity.setPos(x, y);
	while(this.ActiveEntityIndex[i] != null) {
		i++;
	}
	
	
	System.out.println("test");
	this.ActiveEntityIndex[i] = entity;
	
		
	}
	
	
	public void callAI() {
	if(game.getGameState() == 1 && game.player.getPlayerState() == 0 && game.gameMenu == 0) {
		for(int i = 0;i < maxEntities;i++) {
			if(this.ActiveEntityIndex[i] != null) {
			this.ActiveEntityIndex[i].callAI();
		}
		}
		
		
	}
		
			
	}
	
	
	public Entity getIndex(int i) {
		Entity entity;
		entity = this.ActiveEntityIndex[i];
		return entity;
	}
	
	public Entity EntityAtPos(int x, int y) {
		Entity entity;
		entity = null;
		for(int i = 0; i < this.maxEntities;i++) {
			if(this.ActiveEntityIndex[i] != null) {
			if(this.ActiveEntityIndex[i].getX() == x && this.ActiveEntityIndex[i].getY() == y) {
				entity = this.ActiveEntityIndex[i];
			}
			}
		}
		return entity;
	}
}
