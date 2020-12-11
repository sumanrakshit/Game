import java.awt.*;
import java.io.*;
import java.lang.Thread;
class Banner extends Frame implements Runnable
{
String str="SUMAN,LOOK AT ME (00)  ";
Banner()
{
setLayout(null);
setBackground(Color.cyan);
setForeground(Color.red);
}
public void paint(Graphics g)
{
Font f=new Font("Courier",Font.BOLD,40);
g.setFont(f);
g.drawString(str,10,100);
}
public void run()
{
for(; ;)
{
repaint();
try
{
Thread.sleep(300);
}catch(InterruptedException ie){}
char ch=str.charAt(0);
str=str.substring(1,str.length());
System.out.println("");
str=str+ch;
}

}
public  static void main(String args[])
{
Banner b=new Banner();
b.setSize(400,400);
b.setTitle("MY BANNER");
b.setVisible(true);
Thread t=new Thread(b);
t.start();
} 
}