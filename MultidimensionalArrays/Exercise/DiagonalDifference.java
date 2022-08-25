package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimension = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int sumRight = 0;
        int sumLeft = 0;
        for (int i = 0; i < dimension; i++) {
            sumRight += matrix[i][i];
            sumLeft += matrix[i][dimension - 1 - i];
        }
        System.out.println(Math.abs(sumRight - sumLeft));
    }
}
