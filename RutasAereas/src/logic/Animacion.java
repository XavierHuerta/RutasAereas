package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Animacion extends JLabel{
    private Timer timer;
    private double t;
    
    public Animacion( QuadCurve2D curve){
        setIcon(new ImageIcon("src/images/avionIzq.png"));
        setSize(24, 24);

        // Crea un temporizador para actualizar la posición
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcula la posición en la curva para el valor actual de t
                Point2D point = calculatePointOnCurve(curve, t);
                int x = (int) point.getX() - getWidth() / 2;
                int y = (int) point.getY() - getHeight() / 2;
                setLocation(x, y);

                // Incrementa t para el siguiente paso de la animación
                t += 0.01;
                if (t > 1) {
                    // Si t excede 1, detiene la animación
                    timer.stop();
                }
            }
        });
    }

    // Calcula el punto en la curva para un valor t dado
    private Point2D calculatePointOnCurve(QuadCurve2D curve, double t) {
        double x = curve.getX1() * (1 - t) * (1 - t) + 2 * curve.getCtrlX() * (1 - t) * t + curve.getX2() * t * t;
        double y = curve.getY1() * (1 - t) * (1 - t) + 2 * curve.getCtrlY() * (1 - t) * t + curve.getY2() * t * t;

        return new Point2D.Double(x, y);
    }
}
