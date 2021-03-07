package aotr.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;

public class GenerateWorldMenu {

int menuselector;	
int selectorHeight;
Main game;

public GenerateWorldMenu(Main game){
	this.menuselector = 0;
	this.game = game;
}
	
public void tick() {
	
}



public void render(Graphics g, int windowWidth, int windowHeight) {

	g.setFont(new Font( "Times New Roman", Font.PLAIN, 5* windowHeight/100));
	g.setColor(Color.white);
	String world = "world";
	String size = "world size";
	String settings = "Settings";
	String generateWorld = "generate world";
	
	
	switch(this.menuselector) {
	case 0:
		world = ">" + world;
		break;
	case 1:
		size = ">" + size;
		break;
	case 2:
		settings = ">" + settings;
		break;
	case 3:
		generateWorld = ">" + generateWorld;
		break;
	
	}
	
	g.drawString(world, windowWidth / 15, windowHeight/10 );
	g.drawString(size, windowWidth / 15, windowHeight/10 *2);
	g.drawString(settings, windowWidth / 15, windowHeight/10 *3);
	g.drawString(generateWorld, windowWidth / 15, windowHeight/10 *4);
	

}


public void select() {

if(this.game.getGameState() == 3) {	
switch(this.menuselector) {
case 0:
	
	
	break;
case 1:
	
	break;
	
case 2:
	
	break;
case 3:
	game.generateWorld();
	break;

}
}

}






public void menuScrollUp() {
	if(game.getGameState() == 3) {
	if (menuselector > 0) {
		this.menuselector--;
	}else {
		this.menuselector = 3; 	
				}	
	}
}

public void menuScrollDown() {
	
	if(game.getGameState() == 3) {
	if (menuselector < 3) {
		this.menuselector= this.menuselector + 1;
	}else {
		this.menuselector = 0;
	}
}
}



public void setMenuSelector(int input) {
	this.menuselector = input;
}

}
