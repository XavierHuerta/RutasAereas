
package ui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.html.StyleSheet.ListPainter;

import java.io.*;

import logic.Grafo;
import logic.Vertice;
import logic.aeropuertos;


public class MainFrame extends JFrame{
    private JComboBox<String> listaPais;
    private JComboBox<String> listaCiudad;
    
    public MainFrame(){
        initComponents();
        setBackground(Color.decode("#2482B5"));
    }

    public void initComponents(){
        setLayout(null);
        getContentPane().setBackground(Color.decode("#A1E5F7"));
        

        //Propiedades del Panel Info
        panelInfo = new JPanel();
        panelInfo.setLayout(null);
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

        
        
        listaPais = new JComboBox<>();
        
        listaPais.addItem("Alemania");
        listaPais.addItem("Canada");
        listaPais.addItem("España");
        listaPais.addItem("Estados Unidos");
        listaPais.addItem("Francia");
        listaPais.addItem("Italia");
        listaPais.addItem("Mexico");
        listaPais.addItem("Reino Unido");
        listaPais.setSelectedIndex(0);
        
        
        listaPais.setBounds(25, 150, 200, 40);
        
        listaCiudad = new JComboBox<>();
        listaCiudad.setBounds(25, 250, 200, 40);

        panelInfo.add(listaPais);
        listaCiudad.addItem("Berlin");
        listaPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaCiudad();
            }
        });

       // panelInfo.add(boton);  
        panelInfo.add(listaCiudad);
        
        
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
    
    // Método para actualizar los elementos de listaCiudad en función de la selección en listaPais
    private void actualizarListaCiudad() {
        String paisSeleccionado = (String) listaPais.getSelectedItem();
        
        listaCiudad.removeAllItems();
        if (paisSeleccionado.equals("Alemania")) {
            listaCiudad.addItem("Berlin");
        } else if (paisSeleccionado.equals("Canada")) {
            listaCiudad.addItem("Toronto");
            listaCiudad.addItem("Vancouver");
        } else if (paisSeleccionado.equals("España")) {
            listaCiudad.addItem("Barcelona");
            listaCiudad.addItem("Sevilla");
        }else if (paisSeleccionado.equals("Estados Unidos")) {
            listaCiudad.addItem("Los Angeles");
            listaCiudad.addItem("Miami");
            listaCiudad.addItem("Nueva York");
        }else if(paisSeleccionado.equals("Francia")){
            listaCiudad.addItem("Paris");
        }else if(paisSeleccionado.equals("Italia")){
            listaCiudad.addItem("Venecia");
        }else if (paisSeleccionado.equals("Mexico")) {
            listaCiudad.addItem("Ciudad de Mexico");
            listaCiudad.addItem("Cancun");
            listaCiudad.addItem("Monterrey");
        }else if(paisSeleccionado.equals("Reino Unido")){
            listaCiudad.addItem("Inglaterra");
        }
            
    }
    
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
                        a.setIcon(new ImageIcon("RutasAereas/src/images/marca2.png"));
                        a.getWin().setVisible(true);
                    }
                    @Override
                    public void mouseExited(MouseEvent evt){
                        a.setSize(24, 24);
                        a.setLocation(a.getX() + 4, a.getY() + 8);
                        a.setIcon(new ImageIcon("RutasAereas/src/images/marca1.png"));
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
