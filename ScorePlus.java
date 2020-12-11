import java.awt.*;
import java.applet.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.Random;

public class ScorePlus extends Item
{
private Starting3 appletInfo;
public ScorePlus(int x,Starting3 appletInfo)
{
super(x);
this.appletInfo=appletInfo;
}
public void performActio(Ball b1)
{

Random r=new Random();
appletInfo.setScore(appletInfo.getScore()+500+r.nextInt(2000));
}
public void paint(Graphics g)
{
g.setColor(Color.BLUE);
super.paint(g);
}
}