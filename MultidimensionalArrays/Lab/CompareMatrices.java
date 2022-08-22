package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix1 = matrixInicialisator(scan);
        int[][] matrix2 = matrixInicialisator(scan);
        boolean areEqual = compareMatices(matrix1, matrix2);

        //      System.out.println(Arrays.deepEquals(matrix1, matrix2) ? "equal" : "not equal");
        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean compareMatices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            int[] arr1 = matrix1[i];
            int[] arr2 = matrix2[i];
            if (arr1.length != arr2.length) {
                return false;
            }
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] != arr2[j]) {
                    return false;
                }
            }
        }
        return true;
    }


    private static int[][] matrixInicialisator(Scanner scan) {
        String[] data = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
