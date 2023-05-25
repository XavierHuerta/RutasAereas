import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        ImageIcon icon = new ImageIcon("src/images/Logo.jpg");
        MainFrame mFrame = new MainFrame();
        mFrame.setSize(1250, 575);
        mFrame.setIconImage(icon.getImage());
        mFrame.setLocationRelativeTo(null);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setResizable(false);
        mFrame.setVisible(true);
    }
}
