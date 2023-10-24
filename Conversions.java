//conversions: length, power, speed, temp, time, volume, weight
//all imports are necessary
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


//must 'extend' JPanel 
//You can rename the class to anything you wish - default is 'PanelTemplate'
public class Conversions extends JPanel
{
	//variables for the overall width and height
	private int w, h;
  private JButton length, power, speed, temp, time, volume, weight, kilometer, meter, centimeter, millimeter, mile, yard, feet, inch;
	private boolean lengthB = false, powerB = false, speedB = false, tempB = false, timeB = false, volumeB = false, weightB = false, kilometerB = false, meterB = false, centimeterB = false, millimeterB = false, mileB = false, yardB = false, feetB = false, inchB = false;
  private String convertFromLength, convertToLength;
  private int kilometerOrder = 0, meterOrder = 0, centimeterOrder = 0, millimeterOrder = 0, mileOrder = 0, yardOrder = 0, feetOrder = 0, inchOrder = 0;
	//sets up the initial panel for drawing with proper size
	public Conversions(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
    this.setBackground(Color.cyan);
		
    length = new JButton("Length");
    power = new JButton("Power");
    speed = new JButton("Speed");
    temp = new JButton("Temperature");
    time = new JButton("Time");
    volume = new JButton("Volume");
    weight = new JButton("Weight");

    //LENGTH JBUTTONS:
    kilometer = new JButton("Kilometers");
    meter = new JButton("Meters");
    centimeter = new JButton("Centimeters");
    millimeter = new JButton("Millimeters");
    mile = new JButton("Miles");
    yard = new JButton("Yards");
    feet = new JButton("Feet");
    inch = new JButton("Inches");
    
    //ADD BUTTONS
    this.add(length);
    this.add(power);
    this.add(speed);
    this.add(temp);
    this.add(time);
    this.add(volume);
    this.add(weight);

    //ADD LENGTH BUTTONS
    this.add(kilometer);
    this.add(meter);
    this.add(centimeter);
    this.add(millimeter);
    this.add(mile);
    this.add(yard);
    this.add(feet);
    this.add(inch);

    //ADD ACTIONLISTENER FOR BUTTONS
    length.addActionListener(new AL());
    power.addActionListener(new AL());
    speed.addActionListener(new AL());
    temp.addActionListener(new AL());
    time.addActionListener(new AL());
    volume.addActionListener(new AL());
    weight.addActionListener(new AL());

    //ADD ACTIONLISTENER FOR LENGTH BUTTONS
    kilometer.addActionListener(new AL());
    meter.addActionListener(new AL());
    centimeter.addActionListener(new AL());
    millimeter.addActionListener(new AL());
    mile.addActionListener(new AL());
    yard.addActionListener(new AL());
    feet.addActionListener(new AL());
    inch.addActionListener(new AL());

    //SET INVISIBLE LENGTH BUTTONS
    kilometer.setVisible(false);
    meter.setVisible(false);
    centimeter.setVisible(false);
    millimeter.setVisible(false);
    mile.setVisible(false);
    yard.setVisible(false);
    feet.setVisible(false);
    inch.setVisible(false);

	}
	
	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics g)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(g);
		
		//all drawings below here:
		//IF STATEMENTS FOR BUTTONS
    if(lengthB)
    {
      g.drawString("Length Converter", 250, 100);
      
      kilometer.setVisible(true);
      meter.setVisible(true);
      centimeter.setVisible(true);
      millimeter.setVisible(true);
      mile.setVisible(true);
      yard.setVisible(true);
      feet.setVisible(true);
      inch.setVisible(true);
      
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    if(powerB)
    {
      g.drawString("Power Converter", 250, 100);
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    if(speedB)
    {
      g.drawString("Speed Converter", 250, 100);
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    if(tempB)
    {
      g.drawString("Temperature Converter", 250, 100);
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    if(timeB)
    {
      g.drawString("Time Converter", 250, 100);
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    if(volumeB)
    {
      g.drawString("Volume Converter", 250, 100);
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    if(weightB)
    {
      g.drawString("Weight Converter", 250, 100);
      length.setVisible(false);
      power.setVisible(false);
      speed.setVisible(false);
      temp.setVisible(false);
      time.setVisible(false);
      volume.setVisible(false);
      weight.setVisible(false);
    }

    //IF STATEMENTS FOR LENGTH BUTTONS
		if(kilometerB)
    {
      g.clearRect(0, 0, getWidth(), getHeight());
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      kilometer.setVisible(false);
      if(kilometerOrder == 1 && meterOrder == 2)
      {
        g.drawString("Convert To: " +convertToLength, 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Multiply by 1,000", 250, 200);
      }

      else if(kilometerOrder == 1 && centimeterOrder == 2)
      {
        g.drawString("Convert To: " +convertToLength, 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Multiply by 100,000", 250, 200);
      }

      else if(kilometerOrder == 1 && millimeterOrder == 2)
      {
        g.drawString("Convert To: Millimeters", 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Multiply by 1,000,000", 250, 200);
      }

      if(kilometerOrder == 1 && mileOrder == 2)
      {
        g.drawString("Convert To: Miles", 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Divide by 1.609", 250, 200);
      }

      if(kilometerOrder == 1 && yardOrder == 2)
      {
        g.drawString("Convert To: Yards", 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Multiply by 1,094", 250, 200);
      }

      if(kilometerOrder == 1 && feetOrder == 2)
      {
        g.drawString("Convert To: Feet", 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Multiply by 3,281", 250, 200);
      }

      if(kilometerOrder == 1 && inchOrder == 2)
      {
        g.drawString("Convert To: Inches", 250, 115);
        meter.setVisible(false);
        centimeter.setVisible(false);
        millimeter.setVisible(false);
        mile.setVisible(false);
        yard.setVisible(false);
        feet.setVisible(false);
        inch.setVisible(false);
        g.drawString("Multiply by 39,370", 250, 200);
      }
    }

    if(meterB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      meter.setVisible(false);
    }

    if(centimeterB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      centimeter.setVisible(false);
    }

    if(millimeterB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      millimeter.setVisible(false);
    }

    if(mileB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      mile.setVisible(false);
    }

    if(yardB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      yard.setVisible(false);
    }

    if(feetB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      feet.setVisible(false);
    }

    if(inchB)
    {
      g.drawString("Convert From: " +convertFromLength, 250, 100);
      g.drawString("Convert To: ", 250, 115);

      inch.setVisible(false);
    }
	}

  public class AL implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource() == length)
      {
        lengthB = true;
      } 
      /*else if(e.getSource() == power)
      {
        powerB = true;
      }
      else if(e.getSource() == speed)
      {
        speedB = true;
      }
      else if(e.getSource() == temp)
      {
        tempB = true;
      }
      else if(e.getSource() == time)
      {
        timeB = true;
      }
      else if(e.getSource() == volume)
      {
        volumeB = true;
      }
      else if(e.getSource() == weight)
      {
        weightB = true;
      }*/
      else if(e.getSource() == kilometer)
      {
        convertFromLength = "Kilometers";
        kilometerOrder = 1;
        kilometerB = true;
      }    
      else if(e.getSource() == meter)
      {
        convertToLength = "Meters";
        meterOrder = 2;
        meterB = true;
      }
      else if(e.getSource() == centimeter)
      {
        centimeterB = true;
        convertToLength = "Centimeters";
        centimeterOrder = 2;
      }

      else if(e.getSource() == millimeter)
      {
        millimeterB = true;
        convertToLength = "Millimeters";
        millimeterOrder = 2;
      }

      else if(e.getSource() == mile)
      {
        mileB = true;
        convertToLength = "Miles";
        mileOrder = 2;
      }

      else if(e.getSource() == yard)
      {
        yardB = true;
        convertToLength = "Yards";
        yardOrder = 2;
      }

      else if(e.getSource() == feet)
      {
        feetB = true;
        convertToLength = "Feet";
        feetOrder = 2;
      }

      else if(e.getSource() == inch)
      {
        inchB = true;
        convertToLength = "Inches";
        inchOrder = 2;
      }
      repaint();
      
    }
  }  
}