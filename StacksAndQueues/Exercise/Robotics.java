package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsWithTime = scan.nextLine().split(";");

        String[] robots = new String[robotsWithTime.length];
        int[] processTime = new int[robotsWithTime.length];
        int[] robotsTime = new int[robotsWithTime.length];

        for (int i = 0; i < robotsWithTime.length; i++) {
            String[] split = robotsWithTime[i].split("-");
            robots[i] = split[0];
            processTime[i] = Integer.parseInt(split[1]);
        }

        String time = scan.nextLine();
        int hours = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt(time.split(":")[2]);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scan.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scan.nextLine();
        }

        while (!products.isEmpty()) {
            sec++;
            if (sec == 60) {
                sec = 0;
                min++;
                if (min == 60) {
                    min = 0;
                    hours++;
                    if (hours == 24) {
                        hours = 0;
                    }
                }
            }

            boolean isProcessed = false;
            String currentProduct = products.poll();
            for (int i = 0; i < robots.length; i++) {
                if (robotsTime[i] <= 0 && !isProcessed) {
                    robotsTime[i] = processTime[i] - 1;
                    isProcessed = true;
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", robots[i], currentProduct, hours, min, sec);
                } else {
                    robotsTime[i]--;
                }
            }
            if (!isProcessed) {
                products.offer(currentProduct);
            }
        }
    }
}
