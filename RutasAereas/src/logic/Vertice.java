import java.awt.*;
import java.awt.geom.*;


class Vertice {
    private String nombre;
    private boolean visitado;
	private Point2D origen; //punto origen (x,y)
	private Ellipse2D circulo;  //nodo visual Skin
	private Color color;
    //Variables para Dijkstra
    private int dv;
    private Vertice pv;
	
    //Variable de clase
    public static int nVertices = 1;  //contador  de vertices creados

    //Diametro Constante
    private final static int diametro = 40;
	

    //Constructores
    public Vertice(){
        this(new Point2D.Double(0,0));
    }
    public Vertice(Point2D p){
        this(p, "" + nVertices); //Se nombra al vertice por su número
    }
    public Vertice(Point2D p, String nombre){
        double x = p.getX();
        double y = p.getY();
        origen = p;
        color = Color.white;
        circulo = new Ellipse2D.Double(x-diametro/2,y-diametro/2,diametro,diametro);
        this.nombre = nombre;

        //variables de dijkstra
        dv = 0;
        pv = null;
        nVertices++; 
    }

    //Metodos del vertice ---------------------------------------
    public void dibujar(Graphics2D g2){
        g2.setPaint(color);
        g2.fill(circulo);
        g2.setPaint(Color.BLACK);
        g2.drawString(nombre, (int) origen.getX(), (int) origen.getY());
        
    }

    //Metodos de acceso
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
    public void setColor(Color c){
   	    color = c;
    }
    public Color getColor() { 
        return color;
    }
    public void setCirculo(Ellipse2D circulo) {
        this.circulo = circulo;
    }
    public Ellipse2D getCirculo() {
        return circulo;
    }
    public Point2D getOrigen(){
        return origen;
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