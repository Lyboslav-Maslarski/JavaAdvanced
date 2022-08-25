package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        fillInTheMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static void fillInTheMatrix(String[][] matrix) {
        char start = 'a';
        for (int i = 0; i < matrix.length; i++) {
            char currentChar = start;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "" + start + currentChar + start;
                currentChar++;
            }
            start++;
        }
    }
}
