# Tic Tac Toe with Java

Enjoy this 2 players based game with AWT Graphics library.

## 'Hand made' graphics

This use primitive 2D shapes to draw the cross, circle and 3x3 grid.

```java
for(int i = 0; i < 9; i++)
{
	g2D.drawRect(w_scale * column_index, h_scale * row_index, w_scale, h_scale);

	if(this.spaces[space_index] == 1)
	{
		g2D.drawLine(w_scale * column_index, h_scale * row_index,
			w_scale * (column_index + 1), h_scale * (row_index + 1));
		g2D.drawLine(w_scale * (column_index + 1), h_scale * row_index,
			w_scale * column_index, h_scale * (row_index + 1));
	}
	else if(this.spaces[space_index] == 2)
	{
		g2D.drawOval(w_scale * column_index, h_scale * row_index, w_scale, h_scale);
	}
  
	space_index++;
	column_index++;
	if(column_index >= 3)
	{
		column_index = 0;
		row_index++;
	}
}
```

## Input and output

The input is via JButtons on the left side panel of screen, and the output is in same panel with JLabels.
