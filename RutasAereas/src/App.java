import javax.swing.ImageIcon;
import javax.swing.JFrame;

import logic.Grafo;
import logic.aeropuertos;
import ui.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo = aeropuertos.nuevografo();;

        ImageIcon icon = new ImageIcon("RutasAereas/src/images/icon.jpg");
        MainFrame mFrame = new MainFrame(grafo);
        mFrame.setSize(1350, 575);
        mFrame.setIconImage(icon.getImage());
        mFrame.setLocationRelativeTo(null);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setResizable(false);
        mFrame.setVisible(true);
    }
}
