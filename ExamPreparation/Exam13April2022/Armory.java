package ExamPreparation.Exam13April2022;

import java.util.Scanner;

public class Armory {
    static char[][] matrix;
    static int goldCoins;
    static int row;
    static int col;
    static boolean haveLeft;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("A")) {
                row = i;
                col = line.indexOf("A");
            }
            matrix[i] = line.toCharArray();
        }

        while (goldCoins < 65) {
            String command = scan.nextLine();
            switch (command) {
                case "up":
                    moveOfficer(-1, 0);
                    break;
                case "down":
                    moveOfficer(1, 0);
                    break;
                case "left":
                    moveOfficer(0, -1);
                    break;
                case "right":
                    moveOfficer(0, 1);
                    break;
            }
            if (haveLeft) {
                break;
            }
        }
        if (haveLeft) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid " + goldCoins + " gold coins.");
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void moveOfficer(int rowMutator, int colMutator) {
        matrix[row][col] = '-';

        row += rowMutator;
        col += colMutator;

        if (row < 0 || col < 0 || row == matrix.length || col == matrix[row].length) {
            haveLeft = true;
            return;
        }
        if (Character.isDigit(matrix[row][col])) {
            goldCoins += (matrix[row][col] - '0');
        } else if (matrix[row][col] == 'M') {
            matrix[row][col] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'M') {
                        row = i;
                        col = j;
                    }
                }
            }
        }
        matrix[row][col] = 'A';
    }
}
