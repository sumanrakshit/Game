import java.awt.*;
import java.applet.*;

public class GravUp extends Item
{
public GravUp(int x)
{
super(x);
}
public void performAction( Ball b1)
{
//b1.setGravity(b1.getGravity()+3);
}
public void paint(Graphics g)
{
g.setColor(Color.RED);
super.paint(g);
}

}