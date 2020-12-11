import java.awt.*;
import java.applet.*;
import java.awt.Graphics;

public class GravDown extends Item
{
public GravDown(int x)
{
super(x);
}
public  void performAction( Ball b1)
{
if(b1.getGravity()>3)
{
b1.setGravity(b1.getGravity()-3);
}
if(b1.getGravity()<3)
{
b1.setGravity(3);
}

}
public void paint(Graphics g)
{
g.setColor(Color.GREEN);
super.paint(g);
}

}