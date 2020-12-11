import java.applet.*;
import java.awt.*;
import java.lang.Thread.*;
public class Ball extends Applet
{
 private int x=400;
 private int y=25;
 private double dx=0;
 private double dy=0; 
private double gameDy=-100;
 private int radius=20;
 private double gravity=15;
 private double energyloss=1;
 private  double dt=.2;
 private double xFriction=.9;
 private int agility=3;
 private int maxSpeed=20;
private boolean game_over=false;
public Ball(int i,int j)
{
x=i;
y=j;
}
public Ball()
{
}
public int getRadius()
{
return radius;
}
public int getX()
{
return x;
}
public void setX(int x)
{
this.x=x;
}
public void setY(int y)
{
this.y=y;
}
public int getY()
{
return y;
}
public void setGameDy(double gameDy)
{
this.gameDy=gameDy;
}
public double getDy()
{
return dy;
}

public double getGravity()
{
return gravity;
}
public int getAgility()
{
return agility;
}
public int getMaxSpeed()
{
return maxSpeed;
}
public void setGravity(double gravity)
{
this.gravity=gravity;
}
public void setAgility(int agility)
{
this.agility=agility;
}
public double getGameDy()
{
return gameDy;
}
public void setDx(double dx)
{
this.dx=dx;
}

public void setDy(double dy)
{
this.dy=dy;
}
public double getDx()
{
return dx;
}
public void moveRight()
{
if(dx+agility<maxSpeed)
{
dx+=agility;
}
}
public void moveLeft()
{
if(dx-agility>-maxSpeed)
{
dx-=agility;
}
}
public void update(Starting3 s)
{
if(x+dx >s.getWidth()-radius)
{
x=s.getWidth()-radius-1;
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
if(y==s.getHeight()-radius){
dx*=xFriction;
if(Math.abs(dx)<.8)
{
dx=0;
}
}
 if(y-200 >s.getHeight()-radius)
{
/* y=s.getHeight()-radius-1;
dy*=energyloss;
dy=gameDy; */
game_over=true;
}

 else
{
dy+=gravity*dt;
y+=dy*dt+.5*gravity*dt*dt;
}
}
public void paint(Graphics g)
{
g.setColor(Color.RED);
g.fillOval(x-radius,y-radius,radius*2,radius*2);

}
public boolean getGameOver()
{
return game_over;
}
}