package ba.bitcamp.ABetterDrawingApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

	private static final long serialVersionUID = 5855038960562458056L;
	private PointArray points;
	private Color activeColor;
	private boolean isTrue = true;

	private static Color[] supportedColors = new Color[] { Color.RED,
			Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK };
	private int pointSize = 15;

	public PaintPanel(int height, int width) {
		super();

		points = new PointArray();
		setSize(width, height);
		setBackground(Color.WHITE);

		JButton size1 = new JButton("+");
		size1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == size1) {
					pointSize += 5;
				}

			}

		});

		JButton size2 = new JButton("-");
		size2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == size2) {
					pointSize -= 5;
				}

			}

		});

		add(size1);
		add(size2);

		for (int i = 0; i < supportedColors.length; i++) {
			JButton color = new JButton("Pick");
			color.setName(Integer.toString(i));
			color.setForeground(supportedColors[i]);

			color.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton clicked = (JButton) e.getSource();

					String name = clicked.getName();
					int index = Integer.parseInt(name);
					activeColor = supportedColors[index];

				}

			});

			add(color);
			addMouseMotionListener(new MouseHandler());
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < points.getLength()-1; i++) {
			Point p = points.elementAt(i);
			if(isTrue == true){
			Point p2 = points.elementAt(i+1);
			g.setColor(p.getColor());
			g2d.setStroke(new BasicStroke(p.getSize()));
			g.drawLine(p.getX(), p.getY(), p2.getX(), p2.getY());	
			}else if(isTrue == false){
				g.setColor(p.getColor());
				g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
		}

	}

	private class MouseHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(), activeColor,
					pointSize);

			if (e.isShiftDown() == true) {
				newPoint.setColor(Color.WHITE);
			}
			if(e.isControlDown() == true){
				isTrue = !isTrue;
			}
			points.addPoint(newPoint);
			repaint();

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}