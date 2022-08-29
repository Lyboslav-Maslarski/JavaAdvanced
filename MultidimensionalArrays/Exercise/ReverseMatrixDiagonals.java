package MultidimensionalArrays.Exercise;

import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        ArrayDeque<StringBuilder> diagonals = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            int row = i;
            int col = 0;
            StringBuilder toAdd = new StringBuilder();
            while (row >= 0 && col < cols) {
                toAdd.append(matrix[row][col]);
                toAdd.append(" ");
                row--;
                col++;
            }
            diagonals.push(toAdd);
        }
        for (int i = 1; i < cols; i++) {
            int row = rows - 1;
            int col = i;
            StringBuilder toAdd = new StringBuilder();
            while (row >= 0 && col < cols) {
                toAdd.append(matrix[row][col]);
                toAdd.append(" ");
                row--;
                col++;
            }
            diagonals.push(toAdd);
        }
        diagonals.forEach(System.out::println);
    }
}
