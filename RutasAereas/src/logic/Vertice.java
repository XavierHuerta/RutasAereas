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
    private int visa;
    private String clima;
    private String atracciones;
    private String costo;
    //Variables para Dijkstra
    private int dv;
    private Vertice pv;
    //Variable de clase
    public static int nVertices = 1;  //contador  de vertices creados
    //Diametro Constante
	private final static int dimencion = 24;
    private static int nLugar;
    //Centro
    private Point2D origen;
    private Point correccion;

    private Win ventanita;

    /* CONSTRUCTORES ------------------------------------------------------------------*/
    public Vertice(){
    }
    public Vertice(int x, int y){
        //this(x,y, "" + nVertices); //Se nombra al vertice por su número
        bandera = new ImageIcon("src/images/marca1.png");
        setIcon(bandera);
        setBounds(x, y, dimencion, dimencion);
        //centro = new Point2D.Double(x, y);

        //Correccion de origen
        correccion = new Point(getLocation().x + 12, getLocation().y + 23);
        System.out.println(correccion.toString());
        origen = correccion;
        mostrarVentana();
        
    }
    public Vertice(int x, int y, String nombre, int index, int visa, String clima, String atracciones, String costo){
        bandera = new ImageIcon("src/images/marca1.png");
        setIcon(bandera);
        setBounds(x, y, dimencion, dimencion);
        nLugar = index;
        //centro = new Point2D.Double(x, y);
        //Correccion de origen
        correccion = new Point(getLocation().x + 12, getLocation().y + 23);

        origen = correccion;
        this.nombre = nombre;
        this.visa=visa;
        this.clima=clima;
        this.atracciones=atracciones;
        this.costo=costo;
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
        ventanita = new Win(this);
    }

    @Override
    public String toString(){
        return nombre;
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
    public int getVisa() {
        return visa;
    }
    public void setVisa(int visa) {
        this.visa = visa;
    }
    public String getClima() {
        return clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public String getAtracciones() {
        return atracciones;
    }
    public void setAtracciones(String atracciones) {
        this.atracciones = atracciones;
    }
    public String getCosto() {
        return costo;
    }
    public void setCosto(String costo) {
        this.costo = costo;
    }
    public void setPv(Vertice pv){
        this.pv = pv;
    }
    public Vertice getPv(){
        return pv;
    }
    public Point2D getOrigen() {
        return this.origen;
    }

    public void setOrigen(Point2D origen) {
        this.origen = origen;
    }
    public JFrame getWin(){
        return ventanita;
    }
    public int getnLugar() {
        return nLugar;
    }
    public void setnLugar(int nLugar) {
        Vertice.nLugar = nLugar;
    }
    
} //fin clase vertice