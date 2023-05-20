package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    public MainFrame(){
        
        initComponents();
        //this.setContentPane(mapa);
    }

    public void initComponents(){
        //setLayout(new FlowLayout());

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.decode("#F2F0EC"));
        panelPrincipal.setVisible(true);

        panelInfo = new JPanel();
        panelInfo.setBackground(Color.white);
        panelInfo.setSize(250, 560);
        panelInfo.setLocation(1000,0);
        panelInfo.setVisible(true);

        panelMapa = new MapaPanel();
        panelMapa.setLayout(null);
        panelMapa.setSize(1000, 560);
        panelMapa.setVisible(true);

        bandera = new PuntoBandera();
        bandera.setText("Aqui");
        bandera.setForeground(Color.CYAN);
        bandera.setBounds(100, 100, 100, 50);

        // JButton boton = new JButton("Haz clic");
        // boton.setBounds(50, 50, 100, 30);
        
        

        //Elementos del panel principal
        panelPrincipal.add(panelMapa, LEFT_ALIGNMENT);
        panelPrincipal.add(panelInfo, RIGHT_ALIGNMENT);

        panelInfo.add(bandera);

        //Elementos del panel mapa
        panelMapa.add(bandera);
        //panelMapa.add(boton);

        //Elementos del Frame
        add(panelPrincipal);
    }

    private JPanel panelPrincipal;
    private JPanel panelInfo;
    private JPanel panelMapa;
    private JLabel bandera;
    

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

    class PuntoBandera extends JLabel{
        private ImageIcon bandera;
        public PuntoBandera(){
            bandera = new ImageIcon("/images/map.png");

            setIcon(bandera);
        }
    }
}
