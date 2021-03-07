package aotr.objects.player;

import java.awt.image.BufferedImage;

import aotr.Main;

public class Look {

int x;	
int y;
Main game;
public BufferedImage tex;


public Look(BufferedImage tex, Main game) {
this.x = 0;
this.y = 0;
this.tex = tex;
this.game = game;
}

public void move(int changeX, int changeY) {
	if (this.game.getGameState() == 1 && game.player.getPlayerState() == 2) {
		if(((this.x + changeX) > -1) && ((this.x + changeX) < game.world.getWidth())) {
		this.x = changeX + this.x;
		}
		if(((this.y + changeY) > -1) && ((this.y + changeY) < game.world.getHeight())) {
		this.y = changeY + this.y;
		}}
		
	}

public void setX(int x) {
	this.x = x;
	
}

public void setY(int y) {
	this.y = y;
	
}

public BufferedImage getTex() {
	return this.tex;
	
}

public int getX() {
	return this.x;
}

public int getY() {
	return this.y;
}
	
	
}
