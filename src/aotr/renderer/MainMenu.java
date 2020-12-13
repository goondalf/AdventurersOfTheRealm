package aotr.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;

public class MainMenu {

int menuselector;	
int selectorHeight;
Main window;

public MainMenu(Main window){
	this.menuselector = 0;
	this.window = window;
}
	
public void tick() {
	
}



public void render(Graphics g, int windowWidth, int windowHeight) {

	g.setFont(new Font( "Times New Roman", Font.PLAIN, 20));
	g.setColor(Color.white);
	g.drawString("   new game", windowWidth / 15, 30);
	g.drawString("   load game", windowWidth / 15, 60);
	g.drawString("   quit", windowWidth / 15, 90);
	
	if(menuselector == 0) {
	selectorHeight = 30;	
	}else if(menuselector == 1) {
	selectorHeight = 60;	
	}else if(menuselector == 2) {
	selectorHeight = 90;	
	}
	
	g.drawString(">", windowWidth / 15, this.selectorHeight);
}


public void select() {
	if(window.getGameState()==0) {
	if(this.menuselector == 0) {
		//System.out.println("new game");
		window.generateWorld();
		window.setGameState(1);
	}else if(this.menuselector == 1) {
		//System.out.println("load game");
	}else if(this.menuselector == 2) {
		window.exit();
	}
	}
}






public void menuScrollUp() {
	if(window.getGameState() == 0) {
	if (menuselector > 0) {
		this.menuselector--;
	}else {
		this.menuselector = 2; 	
				}	
	}
}

public void menuScrollDown() {
	
	if(window.getGameState() == 0) {
	if (menuselector < 2) {
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
