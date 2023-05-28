package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.Timer;

public class AnimacionAvion {
    //Atributos de info
    private ArrayList <Vertice> vertices;
    //private ArrayList <Arista> aristas;
    private ArrayList <Path2D> curvas;
    private int [] nPuntos;

    //atributos de la animación


    public AnimacionAvion(ArrayList <Vertice> vertices, ArrayList <Arista> aristas){
        this.vertices = vertices;
        //this.aristas = aristas;
        crearArrayPath2d(aristas);

        int puntosTotales = nPuntos[0];
        int indexPoint = 0;

        int delay = 50; //Retardo en milisegundos
        Timer timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(indexPoint < puntosTotales){
                    //Obtiene las coordenadas (x,y) correspondientes al indice actual
                    Point2D point = getPointOnPath();
                }
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        timer.start();
    }

    private static Point2D getPointOnPath(Path2D curva, double t){
        Path2D tempPath = (Path2D) curva.clone();

        Path
    }

    //Metodo que llena el array nPuntos con el numero
    //de puntos de cada curva 
    public void totalPuntos(){
        int i = 0;
        double longitudSegmento = 0.1;
        double totalLongitud;

        //Llena el array con los nPuntos de todas las curvas
        for (Path2D curva : curvas) {
            totalLongitud = contarPuntosCurva(curva);
            nPuntos[i] = (int) (totalLongitud / longitudSegmento);
            i++;
        }

    }

    //Metodo que cuenta los puntos de la curva
    private static double contarPuntosCurva(Path2D curva) {
        Path2D tempPath = (Path2D) curva.clone();
        double longitud = 0;
        double [] coords = new double [6];
        double prevX = 0;
        double prevY = 0;

        for (PathIterator iterator = tempPath.getPathIterator(null, 0.1); !iterator.isDone(); iterator.next()) {
            int tipoSegmento = iterator.currentSegment(coords);
            double x = coords[0];
            double y = coords[1];

            if(tipoSegmento == PathIterator.SEG_MOVETO){
                prevX = x;
                prevY = y;
            }
            else if(tipoSegmento == PathIterator.SEG_LINETO){
                longitud += Math.sqrt(Math.pow(x - prevX, 2) + Math.pow(y - prevY, 2));
                prevX = x;
                prevY = y;
            }
            else if(tipoSegmento == PathIterator.SEG_CLOSE){
                //Si la curva se cierra tambien se agrega la lngitud del ultimo segmento al inicio
                longitud += Math.sqrt(Math.pow(x - prevX, 2) + Math.pow(y - prevY, 2));
            }
        }
        return longitud;
    }

    //MEtodo que crea llena el array de objetos path (las curvas del recorrido)
    public void crearArrayPath2d(ArrayList <Arista> aristas){

        for (Arista arista : aristas) {
            curvas.add(arista.getPath2d());
        }
    }
}
