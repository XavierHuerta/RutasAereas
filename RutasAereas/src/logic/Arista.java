import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.JOptionPane;


public class Arista {
    private double peso;
    private Point2D pi, pf; //Pi = punto inicial (x,y) ; pf = punto dinal (x,y)
    private Color color;
    private Line2D linea; //Skin linea

    //Constructores
    public Arista(Point2D pi, Point2D pf){
        this(pi, pf, 0);
        color = Color.RED;
        linea = new Line2D.Double(pi,pf);
        
    }
    public Arista (Point2D pi, Point2D pf, double peso){
        this.peso = peso;
        this.pi = pi;
        this.pf = pf;
        color = Color.RED;
        linea = new Line2D.Double(pi,pf);
    }
 
    //Metodo
    
    public void dibujar(Graphics2D g2){
        g2.setPaint(color);
        g2.draw(linea);
        g2.setPaint(Color.CYAN);

        //mostrar peso entre arista
        g2.drawString(String.valueOf(peso), (float) ((pi.getX() + pf.getX()) / 2), (float) ((pi.getY() + pf.getY()) / 2) );
    }

   public void setPeso(){
        peso = Double.parseDouble(JOptionPane.showInputDialog("Indica el peso:"));
   }

   public void setColor(Color color){
        this.color = color;
   }

   public double getPeso(){
    return peso;
   }
}
