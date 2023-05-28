package ui;


import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Vertice;

public class Win extends JFrame {
    private Vertice v;
    private JPanel pan;
    private JLabel name;
    private JLabel [] galeria;

    public Win( Vertice v){
        this.v = v;
        setSize(200, 300);
        setUndecorated(true);
        setLocationRelativeTo(v);
        initComponents();
    
    }

    private void initComponents() {
        pan = new JPanel();
        pan.setSize(200, 300);
        pan.setVisible(true);

        //Etiqueta con nombre de la ciudad
        name = new JLabel();
        name.setText(v.getNombre());
        
        galeria = new JLabel [4];

        pan.add(name);
        add(pan);
    }

    public void mostrarImagen(){
        if(v.getNombre().equals("París")){

        }
    }
}
