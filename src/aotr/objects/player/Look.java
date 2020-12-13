package aotr.objects.player;

import java.awt.image.BufferedImage;

import aotr.Main;

public class Look {

int x;	
int y;
Main game;
public BufferedImage tex;
private  Player player;

public Look(BufferedImage tex,Player player, Main game) {
this.x = 0;
this.y = 0;
this.tex = tex;
this.player = player;
this.game = game;
}

public void move(int changeX, int changeY) {
	if (this.game.getGameState() == 1 && this.player.lookbool == true) {
		if(((this.x + changeX) > -1) && ((this.x + changeX) < 100)) {
		this.x = changeX + this.x;
		}
		if(((this.y + changeY) > -1) && ((this.y + changeY) < 100)) {
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
