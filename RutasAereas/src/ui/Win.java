package ui;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Vertice;

public class Win extends JFrame {
    private Vertice v;
    private JPanel pan;
    private JPanel fotos;
    private JLabel name;
    private JLabel [] galeria;
    private JLabel visa;

    public Win( Vertice v){
        this.v = v;
        setSize(200, 300);
        setUndecorated(true);
        setLocationRelativeTo(v);
        
        initComponents();
    
    }

    private void initComponents() {

        pan = new JPanel();
        pan.setLayout(null);
        pan.setSize(200, 300);
        pan.setVisible(true);

        //Etiqueta con nombre de la ciudad
        name = new JLabel();
        name.setSize(200, 20);
        name.setLocation(0, 0);
        name.setAlignmentX(CENTER_ALIGNMENT);
        name.setText(v.getNombre());
        
        galeria = new JLabel [4];

        fotos = new JPanel();
        fotos.setBackground(Color.GREEN);
        fotos.setBounds(50, 50, 100, 100);

        visa = new JLabel(new ImageIcon("RutasAereas/src/images/visa16.png"));
        visa.setLocation(166, 266);
        visa.setSize(24, 24);
        

        pan.add(name);
        pan.add(fotos);
        pan.add(visa);
        add(pan);
    }

    public void mostrarImagen(){
        if(v.getNombre().equals("París")){

        }
    }
}
