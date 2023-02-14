package ExamPreparation.Exam18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    static int row = 0;
    static int col = 0;
    static char[][] matrix;
    static List<String> path;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().split(" ")[0]);

        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine().replace(" ", "");
            if (line.contains("Y")) {
                row = i;
                col = line.indexOf("Y");
            }
            matrix[i] = line.toCharArray();
        }

        path = new ArrayList<>();

        String command = scan.nextLine();
        while (!"Finish".equals(command)) {

            path.add(command);

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

            command = scan.nextLine();
        }

        if (matrix[row][col] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        int newRow = row + rowMutator;
        int newCol = col + colMutator;
        if (newRow < 0 || newCol < 0 || newRow == matrix.length || newCol == matrix[newRow].length) {
            path.remove(path.size() - 1);
            return;
        }
        if (matrix[newRow][newCol] == 'T') {
            path.remove(path.size() - 1);
            return;
        }

        row = newRow;
        col = newCol;
    }
}
