package aotr.objects;

public class Stats {

	private int maxHealth;
	private int health;
	private int level;
	
	public Stats() {
		this.level = 1;
		this.health = 10;
	}

	public void setMaxHealth(int integer) {
		this.maxHealth = integer;
	}

	public void addHealth() {

	}

	
	public void levelUP() {
		this.level++;
	}

	public int getHealth() {
		return this.health;
	}



}
