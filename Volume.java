/*user inputs volume. multiple vol by 1,000 and choose a rand
num from 1 to num*1,000 if they get it correct set their vol to be that. if they get it wrong they have to try again*/
//all imports are necessary
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//must 'extend' JPanel 
//You can rename the class to anything you wish - default is 'PanelTemplate'
public class Volume extends JPanel
{
	//variables for the overall width and height
	private int w, h;
  private JTextField input, guess;
  private boolean correct;
  private Random rand = new Random();
  private int num, parsedInput;
  private int parsedGuess;
	
	//sets up the initial panel for drawing with proper size
	public Volume(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
    
    input = new JTextField("0", 5);
    this.add(input);
    
    guess = new JTextField("0", 5);
    this.add(guess);
      
    input.addActionListener(new AL());
    guess.addActionListener(new AL());
    
		
	}
	
	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics g)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(g);
		
		//all drawings below here:
		g.drawString("Directions: You type in a desired volume in the first box and your desired volume gets multiplied by 1,000. Then, a random number between 1 and your number*1,000 is selected.", 0, 100);
    g.drawString("If you guess that number correctly in the second box, your volume will be set to your desired volume. If not, the number rerolls.", 0, 115);
    g.drawString("Lower volume = bigger chance to get it quickly, but it also means your volume is quiet. Higher volume = less chance to get it soon but it is nice and loud.", 0, 130);
    if(correct == true)
      g.drawString("Correct, your volume is: " +parsedInput, 200, 70);
    else
      g.drawString("Try again.", 200, 70);
    
		
	}

  public class AL implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      parsedInput = Integer.parseInt(input.getText());
      
      num = rand.nextInt(1, parsedInput*1000);

      parsedGuess = Integer.parseInt(guess.getText());
      
      System.out.println(num);
      
      if(parsedGuess == num)
        correct = true;
      else
        correct = false;

      guess.setText("");
      repaint();
    }
  }
}