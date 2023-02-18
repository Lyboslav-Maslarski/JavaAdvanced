package ExamPreparation.Exam26October2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookWorm {
    static char[][] matrix;
    static StringBuilder initialString;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        initialString = new StringBuilder(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("P")) {
                row = i;
                col = line.indexOf("P");
            }
            matrix[i] = line.toCharArray();
        }
        String command = scan.nextLine();
        while (!"end".equals(command)) {
            switch (command) {
                case "up":
                    movePlayer(-1, 0);
                    break;
                case "down":
                    movePlayer(1, 0);
                    break;
                case "right":
                    movePlayer(0, 1);
                    break;
                case "left":
                    movePlayer(0, -1);
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(initialString);

        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        int newRow = row + rowMutator;
        int newCol = col + colMutator;
        if (newRow < 0 || newCol < 0 || newRow == matrix.length || newCol == matrix[row].length) {
            if (initialString.length() > 0) {
                initialString.deleteCharAt(initialString.length() - 1);
            }
            return;
        }
        matrix[row][col] = '-';
        row = newRow;
        col = newCol;
        if (matrix[row][col] != '-') {
            initialString.append(matrix[row][col]);
        }
        matrix[row][col] = 'P';
    }
}
