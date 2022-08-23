package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] mistakeCoordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int mistake = matrix[mistakeCoordinates[0]][mistakeCoordinates[1]];
        int[][] matrixWithoutMistake = new int[n][];
        for (int i = 0; i < n; i++) {
            matrixWithoutMistake[i] = new int[matrix[i].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == mistake) {
                    int newNumber = 0;
                    if (i - 1 >= 0 && matrix[i - 1][j] != mistake) {
                        newNumber += matrix[i - 1][j];
                    }
                    if (i + 1 < matrix.length && matrix[i + 1][j] != mistake) {
                        newNumber += matrix[i + 1][j];
                    }
                    if (j - 1 >= 0 && matrix[i][j - 1] != mistake) {
                        newNumber += matrix[i][j - 1];
                    }
                    if (j + 1 < matrix[i].length && matrix[i][j + 1] != mistake) {
                        newNumber += matrix[i][j + 1];
                    }
                    matrixWithoutMistake[i][j] = newNumber;
                } else {
                    matrixWithoutMistake[i][j] = matrix[i][j];
                }
            }
        }
        for (int[] arr : matrixWithoutMistake) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
