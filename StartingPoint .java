import java.awt.*;
import java.applet.*;
import java.lang.Thread;
public class StartingPoint extends Applet implements Runnable
{
int x=0;
int y=0;
int dx=1;
int dy=1; 
int radius-10;
public void init()
{
}
public void start()
{
Thread thread=new Thread(this);
thread.start();
}
public void run()
{
while(true)
{
x+=dx;
y+=dy;
repaint();

try{
Thread.sleep(17);
}catch(InterruptedException e)
{
e.printStackTrace()
}
}
}
public void paint()
{
g.setColor(Color.RED);
g.fillOval(x-radius,y-radius,radius*2,radius*2);
}
}