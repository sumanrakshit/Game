import java.awt.*;
import java.applet.*;
import java.lang.Thread;
public class Starting2 extends Applet implements Runnable
{
int x=0;
int y=0;
double dx=10;
double dy=25; 
//int radius=25;
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
if(x+dx >this.getWidth())
{
x=this.getWidth();
dx=-dx;
} 
else if(x+dx<0)
{
x=0;
dx=-dx;
}
else
{
x+=dx;
}
if(y+dy >this.getHeight())
{
y=this.getHeight();
dy=-dy;
}
else if(y+dy<0)
{
y=0;
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
Image img=getImage(getDocumentBase(),"plane.gif");
g.drawImage(img,x,0,null);
}
}