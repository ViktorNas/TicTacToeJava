package net.viktornas.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class GUI extends JFrame
{
	public GUI(String title)
	{
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setTitle(title);
		
		GraphicsPanel graphicsPanel = new GraphicsPanel(200, 200);
		OptionsPanel optionsPanel = new OptionsPanel(150, 200);
		
		this.setLayout(new BorderLayout(5, 5));
		
		this.add(graphicsPanel, BorderLayout.CENTER);
		this.add(optionsPanel, BorderLayout.WEST);
		
		this.pack();
		
		this.setVisible(true);
	}
}