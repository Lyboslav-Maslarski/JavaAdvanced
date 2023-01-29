package ExamPreparation.Exam14December2022;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> foodPortionsQuantities = new ArrayDeque<>();
        Deque<Integer> staminaQuantities = new ArrayDeque<>();
        List<String> peaksConquered = new ArrayList<>();


        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(foodPortionsQuantities::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(staminaQuantities::offer);

        while (!foodPortionsQuantities.isEmpty() && !staminaQuantities.isEmpty()) {

            Integer stamina = staminaQuantities.poll();
            Integer food = foodPortionsQuantities.pop();
            int sum = food + stamina;

            switch (peaksConquered.size()) {
                case 0:
                    if (sum >= 80) {
                        peaksConquered.add("Vihren");
                    }
                    break;
                case 1:
                    if (sum >= 90) {
                        peaksConquered.add("Kutelo");
                    }
                    break;
                case 2:
                    if (sum >= 100) {
                        peaksConquered.add("Banski Suhodol");
                    }
                    break;
                case 3:
                    if (sum >= 60) {
                        peaksConquered.add("Polezhan");
                    }
                    break;
                case 4:
                    if (sum >= 70) {
                        peaksConquered.add("Kamenitza");
                    }
                    break;
            }

        }

        if (peaksConquered.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");

        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (peaksConquered.size() > 0) {
            System.out.println("Conquered peaks:");
            peaksConquered.forEach(System.out::println);
        }
    }
}
