package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
        panelInfo.setBackground(Color.BLACK);
        panelInfo.setSize(250, 460);
        panelInfo.setLocation(900,0);
        panelInfo.setVisible(true);

        panelMapa = new MapaPanel();
        panelMapa.setBackground(Color.green);
        panelMapa.setSize(900, 460);
        panelMapa.setVisible(true);

        panelPrincipal.add(panelMapa, LEFT_ALIGNMENT);
        panelPrincipal.add(panelInfo, RIGHT_ALIGNMENT);

        add(panelPrincipal);
        //add(panelInfo, FlowLayout.LEFT);
    }

    private JPanel panelPrincipal;
    private JPanel panelInfo;
    private JPanel panelMapa;
    private MapaPanel mapa = new MapaPanel();

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
}
