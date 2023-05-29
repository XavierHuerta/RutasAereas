
package ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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


import logic.Grafo;
import logic.Vertice;
import logic.aeropuertos;


public class MainFrame extends JFrame{
    private JPanel panelInfo;
    private JPanel panelMapa;
    private JFrame error;
    private JPanel btnBuscar;
    private JLabel Logo1;
    private JComboBox<String> listaPais;
    private JComboBox<String> listaCiudad, listaD;
    private JLabel paisO, ciudadO, ciudadD;
    
    public MainFrame(){
        initComponents();
        //setBackground(Color.decode("#2482B5"));
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
        panelMapa = new MapaPanel();
        panelMapa.setLayout(null);
        panelMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        panelMapa.setSize(1000, 560);
        panelMapa.setVisible(true);

        
        /*Elementos del panel Info */
        //Logo Aeromexico
        Logo1 = new JLabel();
        Logo1.setBounds(20, 20, 227, 40);
        ImageIcon logo = new ImageIcon("src/images/Logo.png");
        Image imag = logo.getImage();
        Image scalImag = imag.getScaledInstance(Logo1.getWidth(), Logo1.getHeight(), Image.SCALE_SMOOTH);
        Logo1.setIcon(new ImageIcon(scalImag));
        

        //Pais
        //etiqueta de origen
        paisO= new JLabel("Pais de origen:");

        paisO.setForeground(Color.decode("#0B2343"));
        paisO.setBounds(25, 50, 100, 40);

        paisO.setBounds(25, 50, 100, 30);

  
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
        listaPais.setBounds(25, 80, 290, 40);
        
        //Ciudad
        ciudadO = new JLabel("Ciudad de origen:");//Etiqueta
        ciudadO.setForeground(Color.decode("#0B2343"));
        ciudadO.setBounds(25, 120, 290, 40);

        listaCiudad = new JComboBox<>();//Lista desplegada
        listaCiudad.setBounds(25, 150, 290, 40);

        listaCiudad.addItem("Berlin");//Ciudad por default ya que Alemania es el pais por default
        //Muestra lista de ciudades de acuerdo al pais seleccionado
        listaPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaCiudad();
            }
        });

        ciudadD= new JLabel("Ciudad destino:");
        ciudadD.setBounds(25,210,100,40);
        listaD=new JComboBox<>();
        listaD.setBounds(25, 240, 100, 30);

        listaD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaD();
            }
        });


        //Boton buscar para dijsktra 
        btnBuscar = new BtnBuscar();
        btnBuscar.setLocation(40, 400);

        //Agrega etiquetas, lista desplegada y boton buscar al panel
        panelInfo.add(Logo1);
        panelInfo.add(paisO);
        panelInfo.add(listaPais);
        panelInfo.add(ciudadO);
        panelInfo.add(listaCiudad);
        panelInfo.add(ciudadD);
        panelInfo.add(listaD);
        panelInfo.add(btnBuscar);
        
        
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

    // Método para actualizar los elementos de listaCiudad en función de la selección en listaPais
    private void actualizarListaD() {
        String ciudadSeleccionada = (String) listaCiudad.getSelectedItem();
        
        listaCiudad.removeAllItems();
        
            
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


    /* Clase para el boton buscar  ----------------------------------------------------------------------------------------*/
    public class BtnBuscar extends JPanel{
        private JLabel btnBuscar;

        public BtnBuscar(){
            setSize(100, 30);
            setBackground(Color.CYAN);//CYAN
            setVisible(true);

            btnBuscar = new JLabel("Buscar");
            btnBuscar.setSize(40,10);
            btnBuscar.setHorizontalTextPosition((int)MainFrame.CENTER_ALIGNMENT);
            btnBuscar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                  //  String paisOrigen=(String) listaPais.getSelectedItem();
                    String ciudadOrigen=(String) listaCiudad.getSelectedItem();

                    Grafo grafo= aeropuertos.nuevografo();
                    grafo.caminoCorto(ciudadOrigen);

                    
                    
                }
            });

            add(btnBuscar);
        }
    }

}
