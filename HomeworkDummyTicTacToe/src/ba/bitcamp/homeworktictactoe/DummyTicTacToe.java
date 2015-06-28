package ba.bitcamp.homeworktictactoe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * @author Semir
 *
 */
public class DummyTicTacToe extends JFrame{
	
	private static final long serialVersionUID = 3904154177638476415L;


	public static final int NUM = 3;
	private String s;
	private JButton[][] fields;
	

	public DummyTicTacToe() {
		super();
		setLayout(new GridLayout(DummyTicTacToe.NUM, DummyTicTacToe.NUM));
		s = "";
		
		fields = new JButton[DummyTicTacToe.NUM][DummyTicTacToe.NUM];
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j] = new JButton();
				fields[i][j].addActionListener(new Action(fields[i][j]));
				add(fields[i][j]);
			}
		}
		
		setTitle("Dummy Tic Tac Toe");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	
	private class Action implements ActionListener {
		
		private JButton button;
		
		public Action(JButton button) {
			super();
			this.button = button;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(s.equals("X")){
				s = "O";
			} else {
				s = "X";
			}
			button.setText(s);
		}
	}
	
	public static void main(String[] args) {
		new DummyTicTacToe();
	}
}