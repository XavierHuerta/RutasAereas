package logic;

import java.awt.geom.Path2D;
import java.util.ArrayList;

public class AnimacionAvion {
    //Atributos de info
    private ArrayList <Vertice> vertices;
    private ArrayList <Arista> aristas;
    private ArrayList <Path2D> curvas;
    private int [] nPuntos;

    //atributos de la animación


    public AnimacionAvion(ArrayList <Vertice> vertices, ArrayList <Arista> aristas){
        this.vertices = vertices;
        this.aristas = aristas;

        crearArrayPath2d(aristas);
    }

    // private static int countPointsOnCurve(Path2D path, double increment) {
    //     Path2D tempPath = (Path2D) path.clone(); // Clona el objeto Path2D para evitar modificaciones no deseadas

    //     //PathMeasure pathMeasure = new PathMeasure(tempPath, false);
    //     //float pathLength = pathMeasure.getLength();

    //     int totalPoints = 0;
    //     float distance = 0;

    //     // while (distance <= pathLength) {
    //     //     totalPoints++;
    //     //     distance += (float) increment;
    //     // }

    //     return totalPoints;
    // }

    public void crearArrayPath2d(ArrayList <Arista> aristas){

        for (Arista arista : aristas) {
            curvas.add(arista.getPath2d());
        }
    }
}
