package logic;

import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ui.Win;


public class Vertice extends JLabel{
    /*Atributos del Vertice */
    private ImageIcon bandera;
    private String nombre;
    private boolean visitado;
    //Variables para Dijkstra
    private int dv;
    private Vertice pv;
    //Variable de clase
    public static int nVertices = 1;  //contador  de vertices creados
    //Diametro Constante
	private final static int dimencion = 24;
    //Centro
    private Point2D.Double centro;
    private Win ventanita;

    /* CONSTRUCTORES ------------------------------------------------------------------*/
    public Vertice(){
    }
    public Vertice(int x, int y){
        //this(x,y, "" + nVertices); //Se nombra al vertice por su número
        bandera = new ImageIcon("src/images/marca1.png");
        setIcon(bandera);
        setBounds(x, y, dimencion, dimencion);
        centro = new Point2D.Double(x, y);
        mostrarVentana();
        
    }
    public Vertice(int x, int y, String nombre){
        bandera = new ImageIcon("src/images/marca1.png");
        setIcon(bandera);
        setBounds(x, y, dimencion, dimencion);
        centro = new Point2D.Double(x, y);
        this.nombre = nombre;
        mostrarVentana();

        //variables de dijkstra
        dv = 0;
        pv = null;
        nVertices++; 
    }

    /*MEtodos vistosos */
    @Override
    public synchronized void addMouseListener(MouseListener l) {
        
        super.addMouseListener(l);
    }

    public void mostrarVentana(){
        ventanita = new Win();
        ventanita.setSize(200, 300);
    }

    /* Metodos de Acceso --------------------------------------- */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isVisitado() {
        return visitado;
    }
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    public void setDv(int dv){
        this.dv = dv;
    }
    public int getDv(){
        return dv;
    }
    public void setPv(Vertice pv){
        this.pv = pv;
    }
    public Vertice getPv(){
        return pv;
    }
    public Point2D.Double getCentro() {
        return this.centro;
    }

    public void setCentro(Point2D.Double centro) {
        this.centro = centro;
    }
    public JFrame getWin(){
        return ventanita;
    }
} //fin clase vertice