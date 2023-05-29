package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import logic.Grafo;
import logic.Vertice;
import logic.aeropuertos;

public class MapaPanel extends JPanel{
    private Image mapa;
    private Grafo grafo;//Grafo con los destinos

    public MapaPanel(Grafo grafo){
        this.grafo = grafo;
        //grafo = aeropuertos.nuevografo();

        for(Vertice a : grafo.getVertices()){
            a.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt){
                    a.setSize(32, 32);
                    a.setLocation(a.getX() - 4, a.getY() - 8);
                    a.setIcon(new ImageIcon("src/images/marca2.png"));
                    a.getWin().setVisible(true);
                }
                @Override
                public void mouseExited(MouseEvent evt){
                    a.setSize(24, 24);
                    a.setLocation(a.getX() + 4, a.getY() + 8);
                    a.setIcon(new ImageIcon("src/images/marca1.png"));
                    a.getWin().setVisible(false);
                }
            });

            
            //Añade el vertice label al grafo
            add(a);
        }
    }
    public void cargargrafo(){
        /*Creacion de las etiquetas destino */   

    }

    //MEtodo que pinta el mapa en el panel
    @Override
    public void paint(Graphics g){
        mapa = new ImageIcon(getClass().getResource("/images/map.png")).getImage();
        g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; 
        //setBackground(Color.darkGray);
        grafo.dibujarAristas(g2);
    }

    public Grafo getGrafo(){
        return grafo;
    }
}