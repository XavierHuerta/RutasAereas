package ui;


import java.awt.Color;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logic.Vertice;

public class Win extends JFrame {
    private Vertice v;
    private JPanel pan;
    private JPanel fotos;
    private JLabel name;
    private JLabel clima;
    private JLabel galeria;
    private JLabel visa;
    private JTextArea atracciones;
    private JLabel costo;

    public Win( Vertice v){
        this.v = v;
        setSize(500, 300);
        setUndecorated(true);
        
        //Determina la posicion
        //esquina superior Izq
        if((1000 - v.getLocation().getX() > v.getLocation().getX()) && (550 - v.getLocation().getY() > v.getLocation().getY())){
            setLocation((int)v.getLocation().getX() + 100, (int)v.getLocation().getY() + 20);
        }//esquina superior Der
        else if((1000 - v.getLocation().getX() < v.getLocation().getX()) && (550 - v.getLocation().getY() > v.getLocation().getY())){
            setLocation((int)v.getLocation().getX() - 430, (int)v.getLocation().getY() - 50);
        }//esquina inferior Izq
        else if((1000 - v.getLocation().getX() > v.getLocation().getX()) && (550 - v.getLocation().getY() < v.getLocation().getY())){
            setLocation((int)v.getLocation().getX() + 150, (int)v.getLocation().getY() - 100);
        }//esquina inferior Der
        else if((1000 - v.getLocation().getX() < v.getLocation().getX()) && (550 - v.getLocation().getY() < v.getLocation().getY())){
            setLocation((int)v.getLocation().getX() - 450, (int)v.getLocation().getY() - 100);
        }
        
        initComponents();
    
    }

    private void initComponents() {

        pan = new JPanel();
        pan.setLayout(null);
        pan.setBackground(Color.white);
        pan.setSize(400, 300);
        pan.setVisible(true);

        //Etiqueta con nombre de la ciudad
        name = new JLabel();
        name.setSize(100, 20);
        name.setLocation(0, 0);
        ///name.setAlignmentX(CENTER_ALIGNMENT);
        name.setHorizontalTextPosition((int)CENTER_ALIGNMENT);
        name.setText(v.getNombre());
        

        fotos = new JPanel();
        //fotos.setBackground(Color.GREEN);
        fotos.setBounds(25, 40, 250, 150);
        mostrarImagen();

        atracciones = new JTextArea();
        atracciones.setSize(180, 80);
        atracciones.setLocation(0, 160);
        atracciones.setEditable(false);
        String aux=v.getAtracciones();
        String aux2="";
        for(int i=0; i<aux.length();i++){
            if(aux.charAt(i)==','){
                aux2+="\n";
            } else {
                aux2+=aux.charAt(i);
            }
        }
        atracciones.setText("Atracciones: \n"+aux2);

        costo = new JLabel();
        costo.setSize(200, 20);
        costo.setLocation(0, 275);
        costo.setText("Costo promedio: "+v.getCosto());

        clima= new JLabel();
        clima.setSize(200, 20);
        clima.setLocation(0, 250);
        clima.setText("Tipo de clima: "+v.getClima());



        if(v.getVisa() == 1){
            visa = new JLabel(new ImageIcon("RutasAereas/src/images/visa16.png"));
        } else {
            visa = new JLabel(new ImageIcon("RutasAereas/src/images/visa24.png"));
        }
        visa.setLocation(166, 266);
        visa.setSize(24, 24);
        

        pan.add(name);
        pan.add(fotos);
        pan.add(atracciones);
        pan.add(clima);
        pan.add(costo);
        pan.add(visa);
        add(pan);
    }

    public void mostrarImagen(){
        int m = v.getnLugar();
        galeria = new JLabel();
        galeria.setSize(fotos.getWidth(), fotos.getHeight());
        ImageIcon imagen;
        Icon icon;
        switch(m){
            case 0:
                imagen = new ImageIcon("RutasAereas/src/images/paris.jpg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 1:
                imagen = new ImageIcon("RutasAereas/src/images/venecia.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 2:
                imagen = new ImageIcon("RutasAereas/src/images/toronto.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 3:
                imagen = new ImageIcon("RutasAereas/src/images/londres.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 4:
                imagen = new ImageIcon("RutasAereas/src/images/losangeles.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 5:
                imagen = new ImageIcon("RutasAereas/src/images/berlin.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 6:
                imagen = new ImageIcon("RutasAereas/src/images/barcelona.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 7:
                imagen = new ImageIcon("RutasAereas/src/images/nuevayork.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 8:
                imagen = new ImageIcon("RutasAereas/src/images/miami.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 9:
                imagen = new ImageIcon("RutasAereas/src/images/monterrey.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 10:
                imagen = new ImageIcon("RutasAereas/src/images/vancouver.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 11:
                imagen = new ImageIcon("RutasAereas/src/images/cdmx.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 12:
                imagen = new ImageIcon("RutasAereas/src/images/cancun.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 13:
                imagen = new ImageIcon("RutasAereas/src/images/elcairo.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;
            case 14:
                imagen = new ImageIcon("RutasAereas/src/images/sevilla.jpeg");
                icon = new ImageIcon(imagen.getImage().getScaledInstance(galeria.getWidth(), galeria.getHeight(), Image.SCALE_DEFAULT));
                galeria.setIcon(icon);
                break;            
        }
        galeria.setLocation(0, 0);;
        fotos.add(galeria);
    }
}
