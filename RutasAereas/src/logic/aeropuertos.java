package logic;

import java.io.*;
import javax.swing.*;

public class aeropuertos {
    private static JFrame error;

    //MEtodo que crea un grafo con la info de los archivos
    public static Grafo nuevografo(){
        try {
            Grafo grafo = new Grafo(15);
            
            FileReader vertices= new FileReader("RutasAereas/src/infografo/vertices.txt");
            FileReader aristas= new FileReader("RutasAereas/src/infografo/aristas.txt");
            //prueba
            BufferedReader verticesbuffer = new BufferedReader(vertices);
            BufferedReader aristasbuffer = new BufferedReader(aristas);
            String aeropuerto=verticesbuffer.readLine();
            String x=verticesbuffer.readLine();
            String y=verticesbuffer.readLine();
            String index = verticesbuffer.readLine();
            String visa=verticesbuffer.readLine();
            String clima=verticesbuffer.readLine();
            String atracciones=verticesbuffer.readLine();
            String costo=verticesbuffer.readLine();
            while(aeropuerto != null && x != null && y != null && index != null&&clima!= null&&visa!= null&&atracciones!= null){
                grafo.agregarVertice(Integer.parseInt(x), Integer.parseInt(y), aeropuerto, Integer.parseInt(index), Integer.parseInt(visa), clima, atracciones, costo);
                aeropuerto = verticesbuffer.readLine();
                x = verticesbuffer.readLine();
                y = verticesbuffer.readLine();
                index = verticesbuffer.readLine();
                visa = verticesbuffer.readLine();
                clima = verticesbuffer.readLine();
                atracciones = verticesbuffer.readLine();
                costo = verticesbuffer.readLine();
                
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
