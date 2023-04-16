package net.viktornas.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel implements ActionListener
{
	public int width; public int height;
	
	public boolean turn = false;
	public int crossPoints = 0;
	public int circlePoints = 0;
	
	public JButton resetButton;
	public JButton[] spaceButton = new JButton[9];
	public JLabel crossPointsLabel;
	public JLabel circlePointsLabel;
	public JLabel turnLabel;
	
	public OptionsPanel(int width, int height)
	{
		this.width = width; this.height = height;
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.DARK_GRAY);
		
		turnLabel = new JLabel("Play now, circle!");
		turnLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		turnLabel.setForeground(Color.WHITE);
		this.add(turnLabel);
		
		for(int i = 0; i < 9; i++)
		{
			spaceButton[i] = new JButton(".");
			spaceButton[i].addActionListener(this);
			spaceButton[i].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
			this.add(spaceButton[i]);
		}
		
		crossPointsLabel = new JLabel("Cross points: 0");
		crossPointsLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		crossPointsLabel.setForeground(Color.WHITE);
		this.add(crossPointsLabel);
		
		circlePointsLabel = new JLabel("Circle points: 0");
		circlePointsLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		circlePointsLabel.setForeground(Color.WHITE);
		this.add(circlePointsLabel);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		this.add(resetButton);
	}

	private int getTurnResult(int[] result)
	{
		for(int i = 0; i < 3; i++)
		{
			if(result[i] == result[i + 3] && result[i] == result[i + 6])
			{
				return result[i];
			}
		}
		
		for(int i = 0; i < 6; i += 3)
		{
			if(result[i] == result[i + 1] && result[i] == result[i + 2])
			{
				return result[i];
			}
		}
		
		if(result[0] == result[4] && result[0] == result[8])
		{
			return result[0];
		}
		else if(result[2] == result[4] && result[2] == result[6])
		{
			return result[2];
		}
		
		return 0;
	}
	
	private void reset(boolean whoStarts)
	{
		for(int i = 0; i < 9; i++)
		{
			GraphicsPanel.spaces[i] = 0;
			spaceButton[i].setText(".");
			turn = whoStarts;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().getClass() == JButton.class)
		{
			if(e.getSource() == resetButton)
			{
				this.reset((turn)? false : true);
			}
			else
			{
				for(int i = 0; i < spaceButton.length; i++)
				{
					if(spaceButton[i] == e.getSource() && GraphicsPanel.spaces[i] == 0)
					{
						GraphicsPanel.spaces[i] = (turn)? 1 : 2;
						spaceButton[i].setText((turn)? "X" : "O");
						turn = (turn)? false : true;
						break;
					}
				}
			}
			
			int turnResult[] = GraphicsPanel.spaces;
			if(getTurnResult(turnResult) != 0)
			{
				crossPoints += (getTurnResult(turnResult) == 1)? 1 : 0;
				circlePoints += (getTurnResult(turnResult) == 2)? 1 : 0;
				
				this.reset(turn);
			}
			
			crossPointsLabel.setText("Cross points: " + crossPoints);
			circlePointsLabel.setText("Circle points: " + circlePoints);
			
			if(turn)
			{
				turnLabel.setText("Play now, cross!");
			}
			else turnLabel.setText("Play now, circle!");
		}
	}	
}