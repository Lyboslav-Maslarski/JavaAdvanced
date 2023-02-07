package ExamPreparation.Exam18August2021;

import java.util.Scanner;

public class FormulaOne {
    static char[][] matrix;
    static int row;
    static int col;
    static boolean haveFinished = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int commandsCount = Integer.parseInt(scan.nextLine());
        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("P")) {
                row = i;
                col = line.indexOf("P");
            }
            matrix[i] = line.toCharArray();
        }
        for (int i = 0; i < commandsCount; i++) {
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

            if (haveFinished) {
                break;
            }
        }

        if (haveFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        int newRow = row + rowMutator;
        int newCol = col + colMutator;
        if (newRow < 0) {
            newRow = matrix.length - 1;
        } else if (newRow == matrix.length) {
            newRow = 0;
        } else if (newCol < 0) {
            newCol = matrix.length - 1;
        } else if (newCol == matrix.length) {
            newCol = 0;
        }

        if (matrix[newRow][newCol] == 'T') {
            return;
        }

        if (matrix[row][col] != 'B') {
            matrix[row][col] = '.';
        }
        row = newRow;
        col = newCol;

        if (matrix[row][col] == 'F') {
            haveFinished = true;
        } else if (matrix[row][col] == 'B') {
            movePlayer(rowMutator, colMutator);
        }
        matrix[row][col] = 'P';
    }
}
