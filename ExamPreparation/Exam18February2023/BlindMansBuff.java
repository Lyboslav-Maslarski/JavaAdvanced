package ExamPreparation.Exam18February2023;

import java.util.Scanner;

public class BlindMansBuff {
    static char[][] matrix;
    static int row;
    static int col;
    static int touchedOpponents;
    static int movesMade;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().split(" ")[0]);
        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine().replace(" ", "");
            if (line.contains("B")) {
                row = i;
                col = line.indexOf("B");
            }
            matrix[i] = line.toCharArray();
        }

        String command = scan.nextLine();

        while (!"Finish".equals(command)) {

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

            if (touchedOpponents == 3) {
                break;
            }
            command = scan.nextLine();
        }
        System.out.println("Game over!");
        System.out.println("Touched opponents: " + touchedOpponents + " Moves made: " + movesMade);
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        int newRow = row + rowMutator;
        int newCol = col + colMutator;
        if (newRow < 0 || newCol < 0 || newRow == matrix.length || newCol == matrix[row].length) {
            return;
        }
        if (matrix[newRow][newCol] == 'O') {
            return;
        }
        movesMade++;
        if (matrix[newRow][newCol] == 'P') {
            touchedOpponents++;
        }
        row = newRow;
        col = newCol;
    }
}
