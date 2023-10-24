//all imports are necessary
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

//must 'extend' JPanel 
//You can rename the class to anything you wish - default is 'PanelTemplate'
public class RacePanel extends JPanel
{
	//variables for the overall width and height
	private int w, h;
  private int p1Count, p2Count;
  private String curWinner = "";
  private ImageIcon i1, i2;
  private JButton p1Button, p2Button;
  private JLabel p1Label, p2Label, winner;
	
	//sets up the initial panel for drawing with proper size
	public RacePanel(int w, int h)
	{
		this.w = w;
		this.h = h;
    this.p1Count = 0;
    this.p2Count = 0;
		this.setPreferredSize(new Dimension(w,h));
    this.setBackground(Color.cyan);

    p1Label = new JLabel("PLAYER 1 Score: " +p1Count);
    p2Label = new JLabel("PLAYER 2 Score: " +p2Count);
    winner = new JLabel("" +curWinner);
    this.add(p1Label);
    this.add(p2Label);
    this.add(winner);

    p1Button = new JButton("PLAYER 1");
    p2Button = new JButton("PLAYER 2");
		//p1Button.setIcon(i1);
    //p2Button.setIcon(i2);
		p1Button.addKeyListener(new kListener());
    p2Button.addKeyListener(new kListener());
		this.add(p1Button);
    this.add(p2Button);
		
	}
	
	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics g)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(g);
		
		//all drawings below here:
		g.drawString("Directions: Player 1 types 1 to have their counter go up, and Player 2 types 0. First to 100 wins!", 50, 200);
		
		
	}

  public class kListener implements KeyListener{
		
		public void keyTyped(KeyEvent e) {
      if(e.getKeyChar() == '1')
        p1Count++;
      if(e.getKeyChar() == '0')
        p2Count++;
      p1Label.setText("PLAYER 1 Score: " +p1Count);
      p2Label.setText("PLAYER 2 Score: " +p2Count);
      if(p1Count == 100)
      {
        winner.setText("Winner: PLAYER 1!!!");
        i1 = new ImageIcon("winner.jpeg");
        p1Count = 0;
        p2Count = 0;
      }
      if(p2Count == 100)
      {
        winner.setText("Winner: PLAYER 2!!!");
        i2 = new ImageIcon("winner2.jpg");
        p1Count = 0;
        p2Count = 0;
      }
    }
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
	}
}