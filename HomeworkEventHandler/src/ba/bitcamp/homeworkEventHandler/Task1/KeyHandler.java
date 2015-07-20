package ba.bitcamp.homeworkEventHandler.Task1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Task1.getInstance().moveRight();	
		} 
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Task1.getInstance().moveLeft();
		} 
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Task1.getInstance().moveUp();
		} 
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Task1.getInstance().moveDown();;
		} 
	}
}