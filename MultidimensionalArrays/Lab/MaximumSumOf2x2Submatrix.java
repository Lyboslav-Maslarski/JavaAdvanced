package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];
        for (int i = 0; i < dimensions[0] - 1; i++) {
            for (int j = 0; j < dimensions[1] - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                 /*   maxMatrix[0][0] = matrix[i][j];
                    maxMatrix[0][1] = matrix[i][j + 1];
                    maxMatrix[1][0] = matrix[i + 1][j];
                    maxMatrix[1][1] = matrix[i + 1][j + 1];*/
                    maxMatrix = new int[][]{{matrix[i][j], matrix[i][j + 1]}, {matrix[i + 1][j], matrix[i + 1][j + 1]}};
                }
            }
        }
        for (int[] numbers : maxMatrix) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
