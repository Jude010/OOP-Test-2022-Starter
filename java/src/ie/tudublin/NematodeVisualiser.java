package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	Table table;
	ArrayList<Nematode> nematodes = new ArrayList<>();
	int set = 0;


	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			set++;
			set = (set)%(table.getRowCount());
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();

	}
	

	public void loadNematodes()
	{
		table  = loadTable("nematodes.csv","header");

		for(int i = 0 ; i < table.getRowCount() ; i++)
		{
			nematodes.add( i ,new Nematode(table.getRow(i)));
		}


	}


	public void draw()
	{	
		fill(0);


	
		


		for(int i = 0; i < nematodes.get(set).getLength() ; i ++)
		{
			stroke(map(set , 0 , table.getRowCount() , 0 ,255) , 255,255);
			float indent = height*0.8f / 10;

			float offset = (indent/2)*(nematodes.get(set).getLength());
			float x1 = width/2;
			float y1 = height/2 - (offset - (i*indent));

			if(nematodes.get(set).isEyes() == true && i == 0)
			{
				line(x1 , y1, cos(45)*indent + x1, sin(45)*indent + y1);
			}

			circle(x1 ,  y1 , indent);
		}

		
		
	}
}
