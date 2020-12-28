package aotr.renderer;

import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;


public class LoadingScreen {
	private Main window;
	public LoadingScreen(Main Window) {
	this.window = Window;	
	}

	
	public void render(Graphics g, int windowWidth, int windowHeight) {
	g.setFont(new Font("SansSerif", Font.PLAIN, windowHeight / 10 ));
	g.drawString("Loading...", windowWidth/10, windowHeight/10);
	
	}
}
