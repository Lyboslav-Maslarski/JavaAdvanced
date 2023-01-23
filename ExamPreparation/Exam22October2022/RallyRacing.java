package ExamPreparation.Exam22October2022;

import java.util.Scanner;

public class RallyRacing {
    static int kms = 0;
    static boolean hasFinished = false;
    static int carRow = 0;
    static int carCol = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());
        String carNumber = scan.nextLine();

        String[][] matrix = new String[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            switch (command) {
                case "up":
                    moveCar(matrix, -1, 0);
                    break;
                case "down":
                    moveCar(matrix, 1, 0);
                    break;
                case "left":
                    moveCar(matrix, 0, -1);
                    break;
                case "right":
                    moveCar(matrix, 0, 1);
                    break;
            }
            if (hasFinished) {
                break;
            }
            command = scan.nextLine();
        }

        if (hasFinished) {
            System.out.println("Racing car " + carNumber + " finished the stage!");
        } else {
            System.out.println("Racing car " + carNumber + " DNF.");
        }
        System.out.println("Distance covered " + kms + " km.");

        matrix[carRow][carCol] = "C";

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static void moveCar(String[][] matrix, int rowMutator, int colMutator) {
        String newPosition = matrix[carRow + rowMutator][carCol + colMutator];
        carRow += rowMutator;
        carCol += colMutator;

        if (newPosition.equals(".")) {
            kms += 10;

        } else if (newPosition.equals("T")) {
            kms += 30;
            matrix[carRow][carCol] = ".";

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j].equals("T")) {
                        matrix[i][j] = "C";
                        carRow = i;
                        carCol = j;
                    }
                }
            }

            matrix[carRow][carCol] = ".";

        } else if (newPosition.equals("F")) {
            kms += 10;
            hasFinished = true;
        }
    }
}
