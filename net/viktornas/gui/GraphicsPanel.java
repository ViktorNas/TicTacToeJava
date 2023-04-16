package net.viktornas.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GraphicsPanel extends JPanel implements ActionListener
{
	public int width; public int height;
	
	public GraphicsPanel(int width, int height)
	{
		this.width = width; this.height = height;
		
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		
		Timer clock = new Timer(250, this);
		clock.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(Color.WHITE);
		g2D.drawOval((width / 2) - 100, (height / 2) - 100, 200, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		super.repaint();
	}

}
