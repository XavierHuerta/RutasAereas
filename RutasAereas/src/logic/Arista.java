package logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.JOptionPane;


public class Arista {
    private double peso; //Costo
    private Point2D pi, pf; //Pi = punto inicial (x,y) ; pf = punto dinal (x,y)
    private Color color;
    //private Line2D linea; //Skin linea
    private QuadCurve2D trayectoria;

    /* CONSTRUCTORES */
    public Arista(Point2D pi, Point2D pf){
        this(pi, pf, 0);
        color = Color.RED;
        //linea = new Line2D.Double(pi,pf);
        
    }
    public Arista (Point2D pi, Point2D pf, int peso){
        this.peso = peso;
        this.pi = pi;
        this.pf = pf;
        color = Color.BLACK;
        //linea = new Line2D.Double(pi,pf);
    }
 
    /* METODOS ----------------------------------------------------------------------------------- */
    //Dibuja la linea
    // public void dibujar(Graphics2D g2){
    //     BasicStroke grosor1 = new BasicStroke(2);//Grosor de la linea
    //     g2.setStroke(grosor1);
    //     g2.setPaint(color);
    //     g2.draw(linea);
    //     g2.setPaint(Color.BLACK);//Color del Peso

    //     //mostrar peso entre arista
    //     //g2.drawString(String.valueOf(peso), (float) ((pi.getX() + pf.getX()) / 2), (float) ((pi.getY() + pf.getY()) / 2) );
    // }

    public void pintar(Graphics2D g){
        g.setColor(Color.white);
        
        //Nueva curva
        trayectoria = new QuadCurve2D.Double(pi.getX(), pi.getY(), (pi.getX() + pf.getX()) / 2, ((pi.getY() + pf.getY()) / 2) - 50, pf.getX(), pf.getY());
        
        //Modifica la linea de la curva y la hace punteada
        //float[] dashPattern = {5, 5};
        //g.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0));
        
        g.setStroke(new BasicStroke(2));
        //Dibuja las curvas
        g.draw(trayectoria);

    }

    @Override
    public String toString(){
        return "" + (int)peso;
    }

    /* METODOS DE ACCESO ------------------------------------------------------------------------------ */
    public void setPeso(){
        peso = Double.parseDouble(JOptionPane.showInputDialog("Indica el peso:"));
    }
    public void setColor(Color color){
        this.color = color;
    }
    public double getPeso(){
        return peso;
    }
    public QuadCurve2D getCurva(){
        return trayectoria;
    }
}
