package logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.JOptionPane;


public class Arista {
    private double peso; //Costo
    private Point2D pi, pf; //Pi = punto inicial (x,y) ; pf = punto dinal (x,y)
    private Color color;
    //private Line2D linea; //Skin linea
    private Path2D curva;

    /* CONSTRUCTORES */
    public Arista(Point2D pi, Point2D pf){
        this(pi, pf, 0);
        color = Color.RED;
        //linea = new Line2D.Double(pi,pf);
        
    }
    public Arista (Point2D pi, Point2D pf, double peso){
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

    public void pintar(Graphics g){
        g.setColor(Color.red);

        //Calcular punto medio

        curva = new Path2D.Double();//Crea un path que es como un pincel
        curva.moveTo(pi.getX(), pi.getY());//mueve el pincel a la posicion inicial
        curva.curveTo(pi.getX(), pi.getY(), (pi.getX() + pf.getX()) / 2, 
                    ((pi.getY() + pf.getY()) / 2) - 50, pf.getX(), pf.getY());//Dibuja la curva en puntos especificados

        //Modifica la linea de la curva y la hace punteada
        float[] dashPattern = {5, 5};
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0));
        g2d.draw(curva);

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
    public Path2D getPath2d(){
        return curva;
    }
}
