import java.awt.*;
import java.applet.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.Random;
import java.applet.Applet;
import java.applet.AudioClip;

public class Starting3 extends Applet implements Runnable,KeyListener,MouseMotionListener,MouseListener
{
Ball b1,b2;
Label lbl;

private Image i;
private Graphics doubleG;
Platform p[]=new Platform[12];
Item item[]=new Item[3];
private int score;
double cityX=0;
double cityDx=.2;
Image city;
 AudioClip music,wind;
int levelcheck=0;
boolean gameOver=false;
boolean mouseIn=false;
 private int x,y;
public int getX()
{
return x;
}
public int getY()
{
return y;
}
public int getScore()
{
return score;
}
public void setScore(int score)
{
this.score=score;
}

public void init()
{

setSize(800,600);
addKeyListener(this);
addMouseListener(this);
addMouseMotionListener(this);
lbl=new Label("@SUMAN",Label.RIGHT);

add(lbl);
city=getImage(getDocumentBase(),"pubg.png");
music=getAudioClip(getDocumentBase(),"xd.au");
wind=getAudioClip(getDocumentBase(),"xd2.au");
 Pictures p=new Pictures(this);
wind.play();
music.loop();
}
public void start()
{
b1=new Ball();
b2=new Ball(250,250);
score=0;
for(int i=0;i<p.length;i++)
{
Random r=new Random();
p[i]=new Platform(i*110,200);
}
for(int i=0;i<item.length;i++)
{
Random r=new Random();
switch(r.nextInt(5))
{
case 0:
item[i]=new GravUp(getWidth()+2000*i);
break;
case 1:
item[i]=new GravDown(getWidth()+2000*i);
break;
case 2:
item[i]=new FuckUp(getWidth()+2000*i);
break;
case 3:
item[i]=new FuckDown(getWidth()+2000*i);
break;
case 4:
item[i]=new ScorePlus(getWidth()+2000*i,this);
}

}

Thread thread=new Thread(this);
thread.start();
}
public void run()
{
while(true)
{
 gameOver=b1.getGameOver();
if(levelcheck>10000){
Pictures.level++;
levelcheck=0;
}
levelcheck++;
if(cityX>getWidth()*-1)
{
cityX-=cityDx;
}
else
{
cityX=0;
}
if(!gameOver)
{
score++;
}
Random r=new Random();
for(int i=0;i<item.length;i++)
{
if(item[i].isCreateNew())
{
item[i]=null;
switch(r.nextInt(5))
{
case 0:
item[i]=new GravUp(getWidth()+2*r.nextInt(5000));
break;
case 1:
item[i]=new GravDown(getWidth()+2*r.nextInt(5000));
break;
case 2:
item[i]=new FuckUp(getWidth()+2*r.nextInt(5000));
break;
case 3:
item[i]=new FuckDown(getWidth()+2*r.nextInt(5000));
break;
case 4:
item[i]=new ScorePlus(getWidth()+2*r.nextInt(5000),this);
}
item[i].setCreateNew(false);
}
}

b1.update(this);
b2.update(this);
for(int i=0;i<p.length;i++)
{
p[i].update(this,b1);
}
for(int i=0;i<item.length;i++)
{
item[i].update(this,b1);
}
repaint();

try{
Thread.sleep(7);
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

g.setColor(new Color(15,77,147));
g.fillRect(0,0,getWidth(),getHeight());
g.drawImage(city,(int)cityX,0,this);
g.drawImage(city,(int)cityX+getWidth(),0,this);
b1.paint(g);
// b2.paint(g);
for(int i=0;i<p.length;i++)
{
p[i].paint(g);
}
for(int i=0;i<item.length;i++)
{
item[i].paint(g);
}
String s=Integer.toString(score);
Font font=new Font("Serif",Font.BOLD,32);
g.setFont(font);
g.setColor(Color.BLACK);
g.drawString(s,getWidth()-150+2,50+2);
g.setColor(new Color(198,226,255));
g.drawString(s,getWidth()-150,50);

 if(gameOver)
{
g.setColor(Color.WHITE);
g.drawString("GAME OVER",300,300);
g.drawRect(255,320,220,40);
if(mouseIn)
{
g.setColor(Color.RED);
g.drawString("PLAY AGAIN",280,340);
}
else{
g.setColor(Color.WHITE);
g.drawString("GAME OVER",300,300);
}
}
}
public void keyPressed(KeyEvent e)
{
switch(e.getKeyCode())
{
case  KeyEvent.VK_LEFT:
         b1.moveLeft();
         break;
case  KeyEvent.VK_RIGHT:
	b1.moveRight();
        break;
}
}
public void keyReleased(KeyEvent e)
{
}
public void keyTyped(KeyEvent e)
{
}
public void mouseMoved(MouseEvent e)
{
if(e.getX()>280 && e.getX()<460)
{
if(e.getY()>320 && e.getY()<360)
{
mouseIn=true;
}
}
if(e.getX()<280 || e.getX()>460)
{

mouseIn=false;

}
if(e.getY()<320 || e.getY()>360)
{

mouseIn=false;

}
}
public void mouseDragged(MouseEvent e)
{
}
 public void mouseExited(MouseEvent e)

{

} 
public void mouseEntered(MouseEvent e)
{
}
public void mouseClicked(MouseEvent e)
{
if(mouseIn)
{
start();
}
}
public void mousePressed(MouseEvent e)
{
}
public void mouseReleased(MouseEvent e)
{
}
}