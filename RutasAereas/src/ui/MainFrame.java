
package ui;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logic.Animacion;
import logic.Arista;
import logic.Grafo;

public class MainFrame extends JFrame{
    private JPanel panelInfo;
    private JPanel panelMapa;
    private JFrame error;
    private JPanel btnBuscar;
    private JLabel Logo1;
    private JComboBox<String> listaPais;
    private JComboBox<String> listaCiudad, listaD;
    private JLabel paisO, ciudadO, ciudadD;
    private JPanel btn_Buscar;
    private JLabel btn_Label;
    private Grafo grafo;
    private Animacion animacion;
    
    public MainFrame(Grafo grafo){  
        this.grafo = grafo;
        animacion = new Animacion();
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
        panelInfo.setSize(350, 560);
        panelInfo.setLocation(1000,0);
        panelInfo.setVisible(true);

        //Propiedades del Panel Mapa
        panelMapa = new MapaPanel(grafo);
        panelMapa.setLayout(null);
        panelMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        panelMapa.setSize(1000, 560);
        panelMapa.setVisible(true);

        panelMapa.add(animacion);
        
        /*<<<<<<<<<<<<<<<<<<<< Elementos del panel Info >>>>>>>>>>>>>>>>>>>> */

        //Logo Aeromexico
        Logo1 = new JLabel();
        Logo1.setBounds(20, 20, 227, 40);
        ImageIcon logo = new ImageIcon("RutasAereas/src/images/Logo.png");
        Image imag = logo.getImage();
        Image scalImag = imag.getScaledInstance(Logo1.getWidth(), Logo1.getHeight(), Image.SCALE_SMOOTH);
        Logo1.setIcon(new ImageIcon(scalImag));
        
        //Pais
        //etiqueta de origen
        paisO = new JLabel("Pais de origen:");
        paisO.setForeground(Color.decode("#0B2343"));
        paisO.setBounds(25, 60, 100, 40);

        

  
        //Lista desplegada de origen
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
        listaPais.setBounds(25, 90, 290, 40);
        
        //Ciudad
        ciudadO = new JLabel("Ciudad de origen:");//Etiqueta
        ciudadO.setForeground(Color.decode("#0B2343"));
        ciudadO.setBounds(25, 130, 290, 40);

        listaCiudad = new JComboBox<>();//Lista desplegada
        listaCiudad.setBounds(25, 160, 290, 40);

       // listaCiudad.addItem("Berlin");//Ciudad por default ya que Alemania es el pais por default
        //Muestra lista de ciudades de acuerdo al pais seleccionado
        listaPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaCiudad();
            }
        });

        ciudadD = new JLabel("Ciudad destino:");
        ciudadD.setBounds(25,200,100,40);
        listaD = new JComboBox<>();
        listaD.setBounds(25, 230, 150, 40);

        listaCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaD();
            }
        });


        //Boton buscar para dijsktra 
        //btnBuscar = new BtnBuscar();
        // btnBuscar.setLocation(180, 230);
        btn_Buscar = new JPanel();
        btn_Buscar.setBackground(Color.decode("#0B2343"));
        btn_Buscar.setBounds(180, 230, 135, 40);
        btn_Label = new JLabel("Buscar");
        btn_Label.setForeground(Color.white);
        btn_Label.setBounds(0, 0, 135, 40);
        btn_Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Aqui esta el boton");
                
                grafo.getRecorrido().clear();
                grafo.resetRecorrido();
                grafo.getRecorridoAristas().clear();

                System.out.println("Dijkstra");

                //Solicita el vertice inicial
                String nombre_vi = listaCiudad.getSelectedItem().toString();
                System.out.println(nombre_vi);
                //llamamos al metodo caminoCorto
                grafo.caminoCorto(nombre_vi);
                grafo.checar_dvpv();
                
                String nombre_vf = listaD.getSelectedItem().toString();
                System.out.println(nombre_vf);

                System.out.println();
                grafo.mostrarMatrizSimple();
                System.out.println();

                grafo.dijkstra(nombre_vi, nombre_vf);
                panelMapa.repaint();

                for (Arista a : grafo.getRecorridoAristas()) {
                    animacion.runAnimación(a.getCurva());
                }
                
                System.out.println(grafo.mostrarRecorrido());;
            }
        });

        btn_Buscar.add(btn_Label);

        //Agrega etiquetas, lista desplegada y boton buscar al panel
        panelInfo.add(Logo1);
        panelInfo.add(paisO);
        panelInfo.add(listaPais);
        panelInfo.add(ciudadO);
        panelInfo.add(listaCiudad);
        panelInfo.add(ciudadD);
        panelInfo.add(listaD);
        panelInfo.add(btn_Buscar);

        //Adicion de los paneles al JFrame
        add(panelMapa);
        add(panelInfo);
    }

    /*Elementos del Panel Mapa */
    //private Content contentPane;
    

    /*Metodos Varios <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    
    /* 
    ** Método para actualizar los elementos de 
    ** listaCiudad en función de la selección 
    ** en listaPais 
    */
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

    // Método para actualizar los elementos de listaD en función de la selección en listaCiudad
    private void actualizarListaD() {
        String ciudadSeleccionada = (String) listaCiudad.getSelectedItem();

        listaD.removeAllItems();
        
        listaD.addItem("Barcelona");
        listaD.addItem("Berlin");
        listaD.addItem("Cancun");
        listaD.addItem("Ciudad de Mexico");
        listaD.addItem("Londres");
        listaD.addItem("Los Angeles");
        listaD.addItem("Miami");
        listaD.addItem("Monterrey");
        listaD.addItem("Nueva York");
        listaD.addItem("Paris");
        listaD.addItem("Sevilla");
        listaD.addItem("Toronto");
        listaD.addItem("Vancouver");
        listaD.addItem("Venecia");
        

       listaD.removeItem(ciudadSeleccionada);
        
            
    }

}
