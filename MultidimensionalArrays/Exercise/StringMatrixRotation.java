package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(scan.nextLine());
        matcher.find();
        int degrees = Integer.parseInt(matcher.group());
        while (degrees >= 360) {
            degrees -= 360;
        }
        List<String> inputs = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            inputs.add(input);
            input = scan.nextLine();
        }

        int colsCount = inputs.stream().mapToInt(String::length).max().getAsInt();
        char[][] matrix = new char[inputs.size()][colsCount];
        for (int i = 0; i < inputs.size(); i++) {
            matrix[i] = (inputs.get(i) + " ".repeat(colsCount - inputs.get(i).length())).toCharArray();
        }
        if (degrees == 0) {
            printMatrix(matrix);
        } else if (degrees == 90) {
            printMatrix90(matrix);
        } else if (degrees == 180) {
            printMatrix180(matrix);
        } else {
            printMatrix270(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void printMatrix270(char[][] matrix) {
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }


}
