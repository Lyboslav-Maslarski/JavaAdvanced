package ExamPreparation.Exam16December2020;

import java.util.Scanner;

public class Selling {
    static int money = 0;
    static int row = 0;
    static int col = 0;
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String chars = scan.nextLine();
            if (chars.contains("S")) {
                row = i;
                col = chars.indexOf("S");
            }
            matrix[i] = chars.toCharArray();
        }

        while (validatePosition(row, col)) {
            String command = scan.nextLine();
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
            if (money >= 50) {
                break;
            }
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + money);

        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static boolean validatePosition(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        matrix[row][col] = '-';
        row = row + rowMutator;
        col = col + colMutator;
        if (validatePosition(row, col)) {
            if (matrix[row][col] == 'O') {
                matrix[row][col] = '-';
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j] == 'O') {
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
}
