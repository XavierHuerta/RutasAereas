package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logic.Grafo;

public class MainFrame extends JFrame{
    
    public MainFrame(){
        
        initComponents();
        //this.setContentPane(mapa);
    }

    public void initComponents(){
        setLayout(null);

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
        //Etiquetas destino
        // bandera = new PuntoBandera();
        // bandera.setText("Aqui");
        // bandera.setForeground(Color.CYAN);
        // bandera.setBounds(100, 100, 100, 50);
        
        // marca = new JLabel(new ImageIcon("src/images/marcador.png"));
        // marca.setBackground(Color.BLACK);
        // marca.setBounds(40, 40, 30, 30);

        // destino = new JLabel(new ImageIcon("src/images/bandera.png"));
        // destino.setBounds(150, 150, 26, 26);
        // //Etiqueta para paris
        // paris = new PuntoBandera();
        // paris.setBounds(780, 280, 30, 30);

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
        //panelMapa.add(bandera);
        // panelMapa.add(marca);
        // panelMapa.add(destino);
        // panelMapa.add(paris);
        for(JLabel a : grafo.getVertices()){
            panelMapa.add(a);
        }
        
 
        add(panelMapa);
        add(panelInfo);
    }

    /*Elementos del Panel Mapa */
    //private JPanel panelPrincipal;
    private JPanel panelInfo;
    private JPanel panelMapa;
    //Etiquetas destino
    private Grafo grafo;
    private JLabel bandera;
    private JLabel marca;
    private JLabel destino;
    private JLabel paris;

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
    class PuntoBandera extends JLabel{
        private String nombre;
        private boolean visitado;
        private ImageIcon bandera;

        public PuntoBandera(){
            bandera = new ImageIcon("src/images/bandera.png");
            setIcon(bandera);
        }
    }
}
