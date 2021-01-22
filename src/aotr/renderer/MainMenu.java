package aotr.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;

public class MainMenu {

int menuselector;	
int selectorHeight;
Main game;

public MainMenu(Main game){
	this.menuselector = 0;
	this.game = game;
}
	
public void tick() {
	
}



public void render(Graphics g, int windowWidth, int windowHeight) {

	g.setFont(new Font( "Times New Roman", Font.PLAIN, 5* windowHeight/100));
	g.setColor(Color.white);
	String newGame = "New Game";
	String loadGame = "Load Game";
	String settings = "Settings";
	String exit = "Exit Game";
	
	
	switch(this.menuselector) {
	case 0:
		newGame = ">" + newGame;
		break;
	case 1:
		loadGame = ">" + loadGame;
		break;
	case 2:
		settings = ">" + settings;
		break;
	case 3:
		exit = ">" + exit;
		break;
	
	}
	
	g.drawString(newGame, windowWidth / 15, windowHeight/10 );
	g.drawString(loadGame, windowWidth / 15, windowHeight/10 *2);
	g.drawString(settings, windowWidth / 15, windowHeight/10 *3);
	g.drawString(exit, windowWidth / 15, windowHeight/10 *4);
	

}


public void select() {

if(this.game.getGameState() == 0) {	
switch(this.menuselector) {
case 0:
	game.generateWorld();
	//game.setGameState(1);
	break;
case 1:
	
	break;
	
case 2:
	game.settings.toggleMenu();
	break;
case 3:
	game.exit();
	break;

}
}

}






public void menuScrollUp() {
	if(game.getGameState() == 0) {
	if (menuselector > 0) {
		this.menuselector--;
	}else {
		this.menuselector = 3; 	
				}	
	}
}

public void menuScrollDown() {
	
	if(game.getGameState() == 0) {
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
