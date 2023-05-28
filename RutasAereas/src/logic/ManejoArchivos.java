package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ManejoArchivos {
    
    public static void crearArcivho(String nomArchivo){
        File archivo = new File(nomArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Archivo creado");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            e.printStackTrace();
        }
    }
}
