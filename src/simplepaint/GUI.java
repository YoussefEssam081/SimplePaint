
package simplepaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame implements MouseMotionListener,ActionListener,MouseListener{
        JPanel p1= new JPanel();
        JPanel p2= new JPanel();
        JButton B1 = new JButton("Font Color");
        JButton B2 = new JButton("Background Color");
        JButton B3 = new JButton("Clear Font");
        JButton B4 = new JButton("Clear All");

        JLabel L1 = new JLabel();
        JColorChooser CC = new JColorChooser();
        int CY,CX,OY,OX;
        Graphics graph ;
        Color k,C ;
       
       

    @Override
    public Component add(Component comp) {
        return super.add(comp); //To change body of generated methods, choose Tools | Templates.
    }
        
    public GUI()
    {
        this.setTitle("paint");
        this.show();
        this.setSize(700, 600);
        this.setLocation(320, 90);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p1);
        this.add(p2);
        this.setLayout(null);
        this.setResizable(true);
        p1.setBounds(0, 0, this.getWidth(), 40);
        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBounds(0, 50, this.getWidth(), this.getHeight());
        p2.setBackground(Color.WHITE);
        p1.add(B1); p1.add(B2); p1.add(B3);
        p1.add(B4); 
      
        p2.add(L1);
     
        p1.setLayout(new FlowLayout());      
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);

        B1.addMouseMotionListener(this);
        B2.addMouseMotionListener(this);
        B3.addMouseMotionListener(this);

        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if (e.getSource()== B1)
        {
           k =  CC.showDialog(null,"SET Color",Color.BLACK); 
        }
        else if (e.getSource()==B2) 
        {
            C = CC.showDialog(null,"SET Color",Color.BLACK);
            p2.setBackground(C);
//            p1.setBackground(Color.WHITE);                     //WHY
//            p1.setBackground(Color.LIGHT_GRAY);                //WHY
//            this.setBackground(Color.DARK_GRAY);               //WHY
//            this.setBackground(Color.WHITE);                   //WHY
        }
        else if (e.getSource()==B3)
        {
            p2.setBackground(Color.WHITE);
            p2.setBackground(C);
            p1.setBackground(Color.WHITE);
            p1.setBackground(Color.LIGHT_GRAY);
            this.setBackground(Color.DARK_GRAY);
            this.setBackground(Color.WHITE);
        }
        else if(e.getSource()==B4)
        {
            C = Color.WHITE;
             p2.setBackground(Color.WHITE);
       //     p2.setBackground(Color.LIGHT_GRAY);
            p1.setBackground(Color.WHITE);
            p1.setBackground(Color.LIGHT_GRAY);
            this.setBackground(Color.DARK_GRAY);
            this.setBackground(Color.WHITE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
       OX = e.getX();
       OY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
         graph = getGraphics();
         graph.setColor(k);
         CX = e.getX();
         CY = e.getY();
         if(graph!=null  && CY > 75  )
         {         //draw line if gp context not null
               graph.drawLine(OX, OY, CX, CY);
                //store current coordinates x,y as olds x,y
         }
         else
         {
             CY = 75;
         }      
         OX =CX;
         OY=CY;
         
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
     
    }    
}

     
            

       
        
    