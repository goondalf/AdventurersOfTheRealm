package aotr.system;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import aotr.Main;

public class keyInput extends KeyAdapter{

Main main;	
public keyInput(Main main) {
this.main = main;
		
}
public void keyPressed(KeyEvent e) {
main.keyPressed(e);	
}

public void keyReleased(KeyEvent e) {
main.keyReleased(e);	
}

}



