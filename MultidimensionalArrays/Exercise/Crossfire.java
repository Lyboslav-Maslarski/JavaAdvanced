package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
        String input = scan.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = data[0];
            int col = data[1];
            int explosion = data[2];
            int start = Math.max(0, row - explosion);
            int end = Math.min(matrix.length - 1, row + explosion);


            for (int i = start; i <= end; i++) {
                if (0 <= i && i < matrix.length && 0 <= col && col < matrix[i].length) {
                    matrix[i][col] = 0;
                }
            }

            if (0 <= row && row < matrix.length) {
                int startCol = Math.max(0, col - explosion);
                int endCol = Math.min(matrix[row].length - 1, col + explosion);
                for (int i = startCol; i <= endCol; i++) {
                    if (0 <= i && i < matrix[row].length) {
                        matrix[row][i] = 0;
                    }
                }
            }

            int[][] newMatrix = new int[matrix.length][];
            for (int i = 0; i < matrix.length; i++) {
                int[] arr = Arrays.stream(matrix[i]).filter(value -> value != 0).toArray();
                newMatrix[i] = arr;
            }
            for (int i = 0; i < newMatrix.length; i++) {
                if (newMatrix[i].length == 0) {
                    if (newMatrix.length - 1 - i >= 0)
                        System.arraycopy(newMatrix, i + 1, newMatrix, i, newMatrix.length - 1 - i);
                    newMatrix[newMatrix.length - 1] = new int[0];
                }
            }
            matrix = newMatrix;
            input = scan.nextLine();

        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] numbers : matrix) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
