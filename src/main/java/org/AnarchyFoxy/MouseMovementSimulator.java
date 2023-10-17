package org.AnarchyFoxy;

import java.awt.AWTException;
import java.awt.Robot;

public class MouseMovementSimulator {
    public static void main(String[] args) {
        try {
            // Utwórz obiekt Robot
            Robot robot = new Robot();

            // Określ odległość i czas ruchu
            int distance = 200; // Przesunięcie w pikselach
            int duration = 1000; // Czas trwania ruchu w milisekundach

            // Pobierz aktualne położenie myszki
            int startX = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getX();
            int startY = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getY();

            // Symuluj ruch myszką w górę
            for (int i = 0; i < distance; i++) {
                robot.mouseMove(startX, startY - i);
                try {
                    Thread.sleep(duration / distance);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Symuluj ruch myszką w dół
            for (int i = 0; i < distance; i++) {
                robot.mouseMove(startX, startY - distance + i);
                try {
                    Thread.sleep(duration / distance);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
