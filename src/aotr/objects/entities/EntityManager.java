package aotr.objects.entities;

import aotr.Main;

public class EntityManager {

private Entity[] ActiveEntityIndex;
private int entityTotal;
private Main game;
	

	public EntityManager(Main game) {
	this.game = game;
	entityTotal = 100;	
	ActiveEntityIndex =	new Entity[entityTotal];

	}
	
	
	public void spawnEntity(int x, int y, int entityID) {
	
	}
	
	
	public void callAI() {
		
	}
	
}
