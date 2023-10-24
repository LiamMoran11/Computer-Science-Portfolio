//all imports are necessary
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;

//must 'extend' JPanel 
//You can rename the class to anything you wish - default is 'PanelTemplate'
public class Oppenheimer extends JPanel
{
	//variables for the overall width and height
	private int w, h;
  private Timer t;
  private int x = 600, y = 200;
  private boolean exploded = false;
  private ImageIcon explosion;
  private boolean horizontal = true;
  private JLabel op;
	
	//sets up the initial panel for drawing with proper size
	public Oppenheimer(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
    t = new Timer(10, new bombTimer());
    t.start();
    explosion = new ImageIcon("bomb.jpg");
		
	}
	
	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics g)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(g);
		
		//all drawings below here:
    if(!(exploded))
    {
      if(horizontal)
      {
        int[] xAxisH = {x, x+5, x+15, x+20, x+20, x+15, x+5};
        int[] yAxisH = {y, y-5, y-5, y-10, y+10, y+5, y+5};
        g.fillPolygon(xAxisH, yAxisH, xAxisH.length);
      }
      else if(!(horizontal))
      {
        int[] xAxisV = {x, x-5, x-5, x-10, x+10, x+5, x+5};
        int[] yAxisV = {y, y-5, y-15, y-20, y-20, y-15, y-5};
        g.fillPolygon(xAxisV, yAxisV, xAxisV.length);
      }
    }
    else if(exploded)
    {
      g.drawImage(explosion.getImage(), 0, 0, this);
      op = new JLabel("Oppenheimer 7/21/23");
      Dimension size = op.getPreferredSize();
      op.setBounds(0, 450, size.width, size.height);
      this.add(op);
      
    }
    
		
		
	}
  private class bombTimer implements ActionListener
  {        
    public void actionPerformed(ActionEvent e) 
    {
      if(x > 200)
      {
        x--;
      }
      else if(x <= 200 && y <= h-7)
      {
        horizontal = false;
        y++;
      }
      else
        exploded = true;
      repaint();
    }
  }
}