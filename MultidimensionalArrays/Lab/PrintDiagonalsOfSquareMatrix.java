package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] diagonals = new int[2][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isDiagonal = i == matrix.length - 1 - j && j == matrix.length - 1 - i;
                if (n % 2 == 0) {
                    if (i == j) {
                        diagonals[0][j] = matrix[i][j];
                    } else if (isDiagonal) {
                        diagonals[1][j] = matrix[i][j];
                    }
                } else {
                    if (i == j) {
                        diagonals[0][j] = matrix[i][j];
                        diagonals[1][j] = matrix[i][j];
                    } else if (isDiagonal) {
                        diagonals[1][j] = matrix[i][j];
                    }
                }
            }
        }
        for (int[] diagonal : diagonals) {
            for (int num : diagonal) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
