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
		if (keyCode == RIGHT)
		{
			if(set == 0)
			{
				set = table.getRowCount();
			}
			set--;
			
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
		textAlign(CENTER);

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
		background(0);

	
		


		for(int i = 0; i < nematodes.get(set).getLength() ; i ++)
		{
			

			stroke(map(set , 0 , table.getRowCount() , 0 ,255) , 255,255);
			float indent = height*0.8f / 10;

			float offset = (indent/2)*(nematodes.get(set).getLength());
			float x1 = width/2;
			float y1 = height/2 - (offset - (i*indent));

			if(nematodes.get(set).isEyes() == true && i == 0)
			{
				line(x1 , y1, x1 + cos(45)*indent, y1 - sin(45)*indent);
				line(x1 , y1, x1 - cos(45)*indent, y1 - sin(45)*indent);
				circle(x1 - cos(45)*indent,y1 - sin(45)*indent , 5);
				circle(x1 + cos(45)*indent,y1 - sin(45)*indent , 5);
			}
			if(nematodes.get(set).isLegs() == true)
			{
				line(x1 - indent , y1 , x1 + indent , y1 );
			}
			
			if(nematodes.get(set).getGender() == "m" && i ==  nematodes.get(set).getLength()-1)
			{
				line(x1 , y1 ,x1 , y1+ indent);
				circle(x1 , y1 + indent , 5);
			}
			if(nematodes.get(set).getGender() == "f" && i ==  nematodes.get(set).getLength()-1)
			{
				circle(x1, y1 , indent*.8f); 
			}
			if(nematodes.get(set).getGender() == "h" && i ==  nematodes.get(set).getLength()-1)
			{
				line(x1 , y1 ,x1 , y1+ indent);
				circle(x1 , y1 + indent , 5);
				circle(x1, y1 , indent*.8f); 
			}



			circle(x1 ,  y1 , indent);

			text(nematodes.get(set).getName(), x1, height*0.9f);
		}

		
		
	}
}
