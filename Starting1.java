import java.awt.*;
import java.applet.*;
import java.lang.Thread;
public class Starting1 extends Applet implements Runnable
{
int x=100;
int y=25;
double dx=2;
double dy=2; 
int radius=25;
private Image i;
private Graphics doubleG;
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
if(x+dx >this.getWidth()-radius)
{
x=this.getWidth()-radius-1;
dx=-dx;
} 
else if(x+dx<0+radius)
{
x=0+radius;
dx=-dx;
}
else
{
x+=dx;
}
if(y+dy >this.getHeight()-radius)
{
y=this.getHeight()-radius-1;
dy=-dy;
}
else if(y+dy<0+radius)
{
y=0+radius;
dy=-dy;
}
 else
{
y+=dy;
}

repaint();

try{
Thread.sleep(5);
}catch(InterruptedException e)
{
e.printStackTrace();
}
}

}
public void stop()
{
}
public void destroy()
{
}
public void update(Graphics g)
{
if(i==null)
{
i=createImage(this.getSize().width,this.getSize().height);
doubleG=i.getGraphics();
}
doubleG.setColor(getBackground());
doubleG.fillRect(0,0,this.getSize().width,this.getSize().height);
doubleG.setColor(getForeground());
paint(doubleG);
g.drawImage(i,0,0,this);
}
public void paint(Graphics g)
{
g.setColor(Color.RED);
g.fillOval(x-radius,y-radius,radius*2,radius*2);
}
}