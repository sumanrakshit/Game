import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class Game extends JApplet implements MouseMotionListener,MouseListener


{
JButton b;
JLabel lbl;
static int score=0;
public void init()
{

Container c=getContentPane();
c.setLayout(null);
ImageIcon ii=new ImageIcon("ph.gif");
b=new JButton("click me",ii);

b.setFont(new Font("Helvetica",Font.BOLD,30));
b.setBounds(400,300,150,75);
c.add(b);
lbl=new JLabel();
lbl.setFont(new Font("Impact",Font.PLAIN,30));
lbl.setText("Score:"+score);
lbl.setBounds(550,20,150,50);
c.add(lbl);
b.addMouseMotionListener(this);
b.addMouseListener(this);
}
public void mouseDragged(MouseEvent me)
{
ImageIcon ii=new ImageIcon("ph.gif");
b.setIcon(ii);
int x=(int)(600*Math.random());
int y=(int)(500*Math.random());
b.setBounds(x,y,150,75);
}
public void mouseMoved(MouseEvent me)
{
int x=(int)(600*Math.random());
int y=(int)(500*Math.random());
b.setBounds(x,y,150,75);
}
public void mouseClicked(MouseEvent e)
{
score=0;
ImageIcon ii=new ImageIcon("ph1.gif");
b.setIcon(ii);
lbl.setForeground(Color.red);
score+=100;
lbl.setText("Score:"+score);

}
public void mouseEntered(MouseEvent e)
{
int x=(int)(600*Math.random());
int y=(int)(500*Math.random());
setBounds(x,y,150,75);
}
public void mouseExited(MouseEvent e)
{

ImageIcon ii=new ImageIcon("ph.gif");
b.setIcon(ii);
}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}


}