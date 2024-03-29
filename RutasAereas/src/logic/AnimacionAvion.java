package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

public class AnimacionAvion extends JFrame {
    private JLabel label;
    private Timer timer;
    private double t;

    //Constructor
    public AnimacionAvion() {
        setTitle("JLabel Curve Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Crea una curva QuadCurve2D
        QuadCurve2D curve = new QuadCurve2D.Double(50, 200, 200, 50, 350, 200);

        // Crea un JLabel
        label = new JLabel(new ImageIcon("src/images/avionIzq.png"));
        label.setBounds(0, 0, 100, 20);
        add(label);

        // Crea un temporizador para actualizar la posición
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcula la posición en la curva para el valor actual de t
                Point2D point = calculatePointOnCurve(curve, t);
                int x = (int) point.getX() - label.getWidth() / 2;
                int y = (int) point.getY() - label.getHeight() / 2;
                label.setLocation(x, y);

                // Incrementa t para el siguiente paso de la animación
                t += 0.01;
                if (t > 1) {
                    // Si t excede 1, detiene la animación
                    timer.stop();
                }
            }
        });

        setVisible(true);

        // Inicia la animación
        timer.start();
    }

    // Calcula el punto en la curva para un valor t dado
    private Point2D calculatePointOnCurve(QuadCurve2D curve, double t) {
        double x = curve.getX1() * (1 - t) * (1 - t) + 2 * curve.getCtrlX() * (1 - t) * t + curve.getX2() * t * t;
        double y = curve.getY1() * (1 - t) * (1 - t) + 2 * curve.getCtrlY() * (1 - t) * t + curve.getY2() * t * t;

        return new Point2D.Double(x, y);
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(new Runnable() {
    //         @Override
    //         public void run() {
    //             new AnimacionAvion();
    //         }
    //     });
    // }
}
