import java.awt.*;
import java.applet.*;
import java.util.*;
import java.util.Random;
public class FuckUp extends Item
{
public FuckUp(int x)
{
super(x);
}
public  void performAction( Ball b1)
{
if(b1.getAgility()<8)
{
b1.setAgility(b1.getAgility()+1);
}
}
public void paint(Graphics g)
{
g.setColor(Color.GREEN);
super.paint(g);
}

}