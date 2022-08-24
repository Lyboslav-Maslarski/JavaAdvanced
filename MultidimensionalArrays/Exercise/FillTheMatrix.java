package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int dimension = Integer.parseInt(input[0]);
        int[][] matrix;
        if (input[1].equals("A")) {
            matrix = creteMatrixA(dimension);
        } else {
            matrix = creteMatrixB(dimension);
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

    private static int[][] creteMatrixA(int dimension) {
        int[][] matrix = new int[dimension][dimension];
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = number;
                number++;
            }
        }
        return matrix;
    }

    private static int[][] creteMatrixB(int dimension) {
        int[][] matrix = new int[dimension][dimension];
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = number;
                    number++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = number;
                    number++;
                }
            }
        }
        return matrix;
    }


}
