package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    public MainFrame(){
        initComponents();
    }

    public void initComponents(){
        //setLayout(new FlowLayout());

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.ORANGE);
        panelPrincipal.setVisible(true);

        panelInfo = new JPanel();
        panelInfo.setBackground(Color.BLACK);
//        panelMapa.setSize(200, 600);
        panelInfo.setVisible(true);

        panelMapa = new JPanel();
        panelMapa.setBackground(Color.green);
        panelMapa.setSize(800, 600);
        panelMapa.setVisible(true);

        panelPrincipal.add(panelMapa, LEFT_ALIGNMENT);
        panelPrincipal.add(panelInfo, RIGHT_ALIGNMENT);

        add(panelPrincipal);
        //add(panelInfo, FlowLayout.LEFT);
    }

    private JPanel panelPrincipal;
    private JPanel panelInfo;
    private JPanel panelMapa;
}
