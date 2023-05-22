package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument.Content;

import logic.Grafo;

public class MainFrame extends JFrame{
    
    public MainFrame(){
        initComponents();
        setBackground(Color.decode("#2482B5"));
    }

    public void initComponents(){
        setLayout(null);
        getContentPane().setBackground(Color.decode("#A1E5F7"));
        

        //Propiedades del Panel Info
        panelInfo = new JPanel();
        panelInfo.setLayout(new FlowLayout());
        panelInfo.setBackground(Color.white);
        panelInfo.setSize(250, 560);
        panelInfo.setLocation(1000,0);
        panelInfo.setVisible(true);

        //Propiedades del Panel Mapa
        panelMapa = new MapaPanel();
        panelMapa.setLayout(null);
        panelMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        panelMapa.setSize(1000, 560);
        panelMapa.setVisible(true);

        /*Creacion de las etiquetas destino */
        grafo = new Grafo();
        grafo.agregarVertice(780, 280, "Paris");
        grafo.agregarVertice(825,300, "Venecia");
        grafo.agregarVertice(400, 313, "Toronto");
        grafo.agregarVertice(760, 260, "Londres");
        grafo.agregarVertice(220, 370, "Los Angeles");
        grafo.agregarVertice(825,260, "Berlin");
        grafo.agregarVertice(775, 325, "Barcelona");
        grafo.agregarVertice(423, 333, "New York");
        grafo.agregarVertice(394, 415, "Miami");

        
        JButton boton = new JButton("Haz clic");
        // boton.setBounds(50, 50, 100, 30);
        

        panelInfo.add(boton);

        //adicion de los marcadores al panelMapa
        for(JLabel a : grafo.getVertices()){
            a.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt){
                    a.setSize(32, 32);
                    a.setLocation(a.getX() - 4, a.getY() - 8);
                    a.setIcon(new ImageIcon("src/images/marca2.png"));
                    

                }
                @Override
                public void mouseExited(MouseEvent evt){
                    a.setSize(24, 24);
                    a.setLocation(a.getX() + 4, a.getY() + 8);
                    a.setIcon(new ImageIcon("src/images/marca1.png"));
                }
            });

            //Añade el vertice label al grafo
            panelMapa.add(a);
        }
        
        //Adicion de los paneles al JFrame
        add(panelMapa);
        add(panelInfo);
    }

    /*Elementos del Panel Mapa */
    //private Content contentPane;
    private JPanel panelInfo;
    private JPanel panelMapa;
    private Grafo grafo;//Grafo con los destinos
    private Point2D p2;

    /*Elementos del panel Info */
    
    

    /*CLASES INTERNAS -------------------------------------------------------------------------------- */

    //Clase para hacer el panel con fondo de mapa
    class MapaPanel extends JPanel{
        private Image mapa;

        @Override
        public void paint(Graphics g){
            mapa = new ImageIcon(getClass().getResource("/images/map.png")).getImage();
            g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    //Clase para hacer etiquetas con un mismo icon
    // class PuntoBandera extends JLabel{
    //     private String nombre;
    //     private boolean visitado;
    //     private ImageIcon bandera;

    //     public PuntoBandera(){
    //         bandera = new ImageIcon("src/images/bandera.png");
    //         setIcon(bandera);
    //     }
    // }
}
