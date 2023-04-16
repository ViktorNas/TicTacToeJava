package net.viktornas.gui;

import java.awt.BasicStroke;
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
	public static int spaces[] = new int[9];
	
	public GraphicsPanel(int width, int height)
	{
		this.width = width; this.height = height;
		
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		
		for(int space : spaces) {space = 0;}
		
		Timer clock = new Timer(250, this);
		clock.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(Color.WHITE);
		
		int space_index = 0;
		int row_index = 0;
		int column_index = 0;
		int w_scale = width / 3;
		int h_scale = height / 3;
		
		for(int i = 0; i < 9; i++)
		{
			g2D.setColor(Color.GREEN);
			g2D.drawRect(w_scale * column_index, h_scale * row_index, w_scale, h_scale);
			
			if(spaces[space_index] == 1)
			{
				g2D.setColor(Color.BLUE);
				g2D.setStroke(new BasicStroke(5));
				g2D.drawLine(w_scale * column_index, h_scale * row_index,
						w_scale * (column_index + 1), h_scale * (row_index + 1));
				g2D.drawLine(w_scale * (column_index + 1), h_scale * row_index,
						w_scale * column_index, h_scale * (row_index + 1));
				g2D.setStroke(new BasicStroke(1));
			}
			else if(spaces[space_index] == 2)
			{
				g2D.setColor(Color.RED);
				g2D.setStroke(new BasicStroke(5));
				g2D.drawOval(w_scale * column_index, h_scale * row_index, w_scale, h_scale);
				g2D.setStroke(new BasicStroke(1));
			}
			
			space_index++;
			column_index++;
			if(column_index >= 3)
			{
				column_index = 0;
				row_index++;
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		super.repaint();
	}
}