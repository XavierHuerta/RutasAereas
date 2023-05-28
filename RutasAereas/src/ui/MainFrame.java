package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.io.*;

import logic.Grafo;
import logic.Vertice;
import logic.aeropuertos;


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

        
        
        JButton boton = new JButton("Haz clic");
        // boton.setBounds(50, 50, 100, 30);
        

        panelInfo.add(boton);

        
        
        //Adicion de los paneles al JFrame
        add(panelMapa);
        add(panelInfo);
    }

    /*Elementos del Panel Mapa */
    //private Content contentPane;
    private JPanel panelInfo;
    private JPanel panelMapa;
    private JFrame error;

    /*Elementos del panel Info */
    

    
    

    /*CLASES INTERNAS -------------------------------------------------------------------------------- */

    //Clase para hacer el panel con fondo de mapa
    class MapaPanel extends JPanel{
        private Image mapa;
        private Grafo grafo;//Grafo con los destinos

        public MapaPanel(){
            
            grafo = aeropuertos.nuevografo();

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
            grafo.dibujar(g2);
        }
    }

}
