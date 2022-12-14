package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] matrix1 = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];
        for (int i = 0; i < rows * 2; i++) {
            if (i < rows) {
                matrix1[i]=scan.nextLine().replace(" ","").toCharArray();
               /* matrix1[i] = Arrays.toString(Arrays.stream(scan.nextLine().split("\\s+")).toArray())
                        .replace("[", "").replace("]", "").replace(",", "").replace(" ", "")
                        .toCharArray();*/
            } else {
                matrix2[i-rows]=scan.nextLine().replace(" ","").toCharArray();
                /*matrix2[i - rows] = Arrays.toString(Arrays.stream(scan.nextLine().split("\\s+")).toArray())
                        .replace("[", "").replace("]", "").replace(",", "").replace(" ", "")
                        .toCharArray();*/
            }
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                if (matrix1[i][j] == matrix2[i][j]) {
                    System.out.print(matrix1[i][j] + " ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}
