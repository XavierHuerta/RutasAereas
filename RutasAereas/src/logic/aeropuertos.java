package logic;

import java.io.*;
import javax.swing.*;

public class aeropuertos {
    private static JFrame error;
    public static Grafo nuevografo(){
        try {
            Grafo grafo = new Grafo();
            
            FileReader vertices= new FileReader("RutasAereas/src/infografo/vertices.txt");
            FileReader aristas= new FileReader("RutasAereas/src/infografo/aristas.txt");
            //prueba
            BufferedReader verticesbuffer = new BufferedReader(vertices);
            BufferedReader aristasbuffer = new BufferedReader(aristas);
            String aeropuerto=verticesbuffer.readLine();
            String x=verticesbuffer.readLine();
            String y=verticesbuffer.readLine();
            String index = verticesbuffer.readLine();
            while(aeropuerto != null && x != null && y != null && index != null){
                grafo.agregarVertice(Integer.parseInt(x), Integer.parseInt(y), aeropuerto, Integer.parseInt(index));
                aeropuerto = verticesbuffer.readLine();
                x = verticesbuffer.readLine();
                y = verticesbuffer.readLine();
                index = verticesbuffer.readLine();
                
            }
            vertices.close();

            /*creacion de las aristas */

            //System.out.println(grafo.buscarVi("Venecia").getOrigen().toString());
            //grafo.
            
            String origen=aristasbuffer.readLine();
            String destino=aristasbuffer.readLine();
            String peso = aristasbuffer.readLine();
            while(origen!=null&&destino!=null&&peso!=null){
                grafo.agregarArista(grafo.buscarVi(origen).getOrigen(), grafo.buscarVi(destino).getOrigen(), Integer.parseInt(peso));
                origen=aristasbuffer.readLine();
                destino=aristasbuffer.readLine();
                peso = aristasbuffer.readLine();
            }
            aristas.close();
            return grafo;
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(error,"Hubo en error al recuperar la información" );
            return null;
        }
    }
}
