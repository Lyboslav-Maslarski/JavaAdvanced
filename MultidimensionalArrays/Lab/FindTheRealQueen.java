package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }
        int x = -1;
        int y = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int validPosition1 = -1;
                int validPosition2 = -1;
                if (matrix[row][col] == 'q') {
                    for (int i = 0; i < matrix.length; i++) {
                        if (matrix[row][i] == 'q' && i != col) {
                            validPosition1 = -1;
                            validPosition2 = -1;
                            break;
                        } else {
                            validPosition1 = row;
                            validPosition2 = col;
                        }
                    }
                    for (int i = 0; i < matrix.length; i++) {
                        if (matrix[i][col] == 'q' && i != row) {
                            validPosition1 = -1;
                            validPosition2 = -1;
                            break;
                        } else {
                            validPosition1 = row;
                            validPosition2 = col;
                        }
                    }
                    int coordinate1 = validPosition1 - 1;
                    int coordinate2 = validPosition2 - 1;
                    while (insideMatrixBOundries(coordinate1, coordinate2, matrix)) {
                        if (matrix[coordinate1][coordinate2] == 'q') {
                            validPosition1 = -1;
                            validPosition2 = -1;
                            break;
                        }
                        coordinate1--;
                        coordinate2--;
                    }
                    coordinate1 = validPosition1 + 1;
                    coordinate2 = validPosition2 + 1;
                    while (insideMatrixBOundries(coordinate1, coordinate2, matrix)) {
                        if (matrix[coordinate1][coordinate2] == 'q') {
                            validPosition1 = -1;
                            validPosition2 = -1;
                            break;
                        }
                        coordinate1++;
                        coordinate2++;
                    }
                    coordinate1 = validPosition1 - 1;
                    coordinate2 = validPosition2 + 1;
                    while (insideMatrixBOundries(coordinate1, coordinate2, matrix)) {
                        if (matrix[coordinate1][coordinate2] == 'q') {
                            validPosition1 = -1;
                            validPosition2 = -1;
                            break;
                        }
                        coordinate1--;
                        coordinate2++;
                    }
                    coordinate1 = validPosition1 + 1;
                    coordinate2 = validPosition2 - 1;
                    while (insideMatrixBOundries(coordinate1, coordinate2, matrix)) {
                        if (matrix[coordinate1][coordinate2] == 'q') {
                            validPosition1 = -1;
                            validPosition2 = -1;
                            break;
                        }
                        coordinate1++;
                        coordinate2--;
                    }
                }
                if (validPosition1 != -1) {
                    x = validPosition1;
                    y = validPosition2;
                }
            }
        }
        System.out.println(x + " " + y);
    }

    private static boolean insideMatrixBOundries(int coordinate1, int coordinate2, char[][] matrix) {
        return 0 <= coordinate1 && coordinate1 < matrix.length && 0 <= coordinate2 && coordinate2 < matrix.length;
    }
}
