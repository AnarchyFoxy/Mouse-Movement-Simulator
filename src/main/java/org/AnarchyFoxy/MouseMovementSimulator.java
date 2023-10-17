package org.AnarchyFoxy;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

public class MouseMovementSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runAgain;

        do {
            runSimulation();
            System.out.print("Czy chcesz uruchomić symulację ponownie? (T/N): ");
            String response = scanner.nextLine().trim().toLowerCase();
            runAgain = response.equals("t");
        } while (runAgain);

        System.out.println("Dziękujemy za skorzystanie z symulatora.");
    }

    public static void runSimulation() {
        try {
            // Utwórz obiekt Robot
            Robot robot = new Robot();

            // Określ odległość i czas ruchu
            int distance = 200; // Przesunięcie w pikselach
            int duration = 1000; // Czas trwania ruchu w milisekundach

            // Pobierz aktualne położenie myszki
            int startX = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getX();
            int startY = (int) java.awt.MouseInfo.getPointerInfo().getLocation().getY();

            // Czas trwania symulacji w milisekundach (np. 1 godzina)
            int simulationDuration = 3600000;

            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < simulationDuration) {
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
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
