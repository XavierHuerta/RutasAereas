package logic;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


class Vertice extends JLabel{
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
	private final static int dimencion = 26;

    /* CONSTRUCTORES ------------------------------------------------------------------*/
    public Vertice(){
    }
    public Vertice(int x, int y){
        //this(x,y, "" + nVertices); //Se nombra al vertice por su número
        bandera = new ImageIcon("src/images/bandera.png");
        setIcon(bandera);
        setBounds(x, y, dimencion, dimencion);
    }
    public Vertice(int x, int y, String nombre){
        bandera = new ImageIcon("src/images/bandera.png");
        setIcon(bandera);
        setBounds(x, y, dimencion, dimencion);
        this.nombre = nombre;

        //variables de dijkstra
        dv = 0;
        pv = null;
        nVertices++; 
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
} //fin clase vertice