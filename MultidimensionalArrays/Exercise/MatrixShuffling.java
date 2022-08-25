package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            if (validCommand(command, rows, cols)) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                int index3 = Integer.parseInt(command[3]);
                int index4 = Integer.parseInt(command[4]);
                String temp = matrix[index1][index2];
                matrix[index1][index2] = matrix[index3][index4];
                matrix[index3][index4] = temp;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static boolean validCommand(String[] command, int rows, int cols) {
        if (!command[0].equals("swap") || command.length != 5) {
            return false;
        }
        int index1 = Integer.parseInt(command[1]);
        int index2 = Integer.parseInt(command[2]);
        int index3 = Integer.parseInt(command[3]);
        int index4 = Integer.parseInt(command[4]);
        return validIndex(index1, rows) && validIndex(index2, cols) && validIndex(index3, rows) && validIndex(index4, cols);
    }

    private static boolean validIndex(int index, int length) {
        return 0 <= index && index < length;
    }
}
