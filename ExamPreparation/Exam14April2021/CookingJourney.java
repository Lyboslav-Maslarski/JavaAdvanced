package ExamPreparation.Exam14April2021;

import java.util.Scanner;

public class CookingJourney {
    static int row;
    static int col;
    static int money;
    static char[][] matrix;
    static boolean haveLeft = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("S")) {
                row = i;
                col = line.indexOf("S");
            }
            matrix[i] = line.toCharArray();
        }

        String command = scan.nextLine();
        while (!haveLeft) {
            switch (command) {
                case "up":
                    movePlayer(-1, 0);
                    break;
                case "down":
                    movePlayer(1, 0);
                    break;
                case "left":
                    movePlayer(0, -1);
                    break;
                case "right":
                    movePlayer(0, 1);
                    break;
            }
            if (money >= 50 || haveLeft) {
                break;
            }
            command = scan.nextLine();
        }

        if (haveLeft) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        matrix[row][col] = '-';
        row += rowMutator;
        col += colMutator;

        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
            haveLeft = true;
            return;
        }

        if (matrix[row][col] == 'P') {
            matrix[row][col] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'P') {
                        row = i;
                        col = j;
                    }
                }
            }
        } else if (Character.isDigit(matrix[row][col])) {
            money += (matrix[row][col] - '0');
        }

        matrix[row][col] = 'S';
    }
}
