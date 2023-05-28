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

            /*Creacion de las etiquetas destino */   
            try {
                grafo = new Grafo();
                FileReader vertices= new FileReader("RutasAereas/src/infografo/vertices.txt");
                FileReader aristas= new FileReader("RutasAereas/src/infografo/aristas.txt");
                BufferedReader verticesbuffer = new BufferedReader(vertices);
                BufferedReader aristasbuffer = new BufferedReader(aristas);
                String linea=verticesbuffer.readLine();
                System.out.println(linea);
                linea=verticesbuffer.readLine();
                grafo.agregarVertice(780, 280, linea);
                System.out.println(linea);
                grafo.agregarVertice(825,300, linea);
                vertices.close();
                aristas.close();
                grafo.agregarVertice(400, 313, "Toronto");
                grafo.agregarVertice(760, 260, "Londres");
                grafo.agregarVertice(220, 370, "Los Angeles");
                grafo.agregarVertice(825,260, "Berlin");
                grafo.agregarVertice(775, 325, "Barcelona");
                grafo.agregarVertice(423, 333, "New York");
                grafo.agregarVertice(394, 415, "Miami");
                grafo.agregarVertice(300, 420, "Monterrey");
                grafo.agregarVertice(200, 285, "Vancouver");
                grafo.agregarVertice(310, 455, "Ciudad de México");
                grafo.agregarVertice(360, 440, "Cancún");
                grafo.agregarVertice(905,395, "El Cairo");
                grafo.agregarVertice(735, 350, "Sevilla");
    
                /*creacion de las aristas */
    
                //System.out.println(grafo.buscarVi("Venecia").getOrigen().toString());
                grafo.agregarArista(grafo.buscarVi("Paris").getOrigen(), grafo.buscarVi("Venecia").getOrigen(), 10);
                grafo.agregarArista(grafo.buscarVi("Monterrey").getOrigen(), grafo.buscarVi("Miami").getOrigen(), 10);
    
                //adicion de los marcadores al panelMapa
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
            } catch (IOException e) {
                JOptionPane.showMessageDialog(error,"Hubo en error al recuperar la información" );
            }
            
            

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
