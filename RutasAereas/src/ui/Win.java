package ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Vertice;

public class Win extends JFrame {
    private Vertice v;
    private JPanel pan;
    private JLabel name;

    public Win( Vertice v){
        this.v = v;
        setSize(200, 300);
        setUndecorated(true);
        setLocationRelativeTo(rootPane);
        initComponents();
    
    }

    private void initComponents() {
        pan = new JPanel();
        pan.setSize(200, 300);
        //pan.setBackground(Color.DARK_GRAY);
        pan.setVisible(true);

        //Etiqueta con nombre de la ciudad
        name = new JLabel("aqui");
        name.setText(v.getNombre());
        
        //name.setForeground(Color.BLACK);

        pan.add(name);
        add(pan);
    }
}
