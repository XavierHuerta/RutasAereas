import javax.swing.JFrame;

import ui.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        MainFrame mFrame = new MainFrame();
        mFrame.setSize(800, 600);
        mFrame.setLocationRelativeTo(null);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setResizable(false);
        mFrame.setVisible(true);
    }
}
