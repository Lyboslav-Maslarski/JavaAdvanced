package ExamPreparation.Exam17Dec2019;

import java.util.Scanner;

public class PresentDelivery {
    static int presents;
    static int totalGivenPresents;
    static int niceKidsWithoutPresents;
    static int niceKidsWithPresents;
    static int row;
    static int col;
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        presents = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine().replace(" ", "");
            if (line.contains("S")) {
                row = i;
                col = line.indexOf("S");
            }
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == 'V') {
                    niceKidsWithoutPresents++;
                }
                matrix[i][j] = c;
            }
        }

        String command = scan.nextLine();
        while (!"Christmas morning".equals(command)) {
            switch (command) {
                case "up":
                    moveSanta(-1, 0);
                    break;
                case "down":
                    moveSanta(1, 0);
                    break;
                case "left":
                    moveSanta(0, -1);
                    break;
                case "right":
                    moveSanta(0, 1);
                    break;
            }
            if (presents == 0) {
                break;
            }
            command = scan.nextLine();
        }
        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        if (niceKidsWithoutPresents == 0) {
            System.out.println("Good job, Santa! " + totalGivenPresents + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + niceKidsWithoutPresents + " nice kid/s.");
        }
    }

    private static void moveSanta(int rowMutator, int colMutator) {
        matrix[row][col] = '-';
        row += rowMutator;
        col += colMutator;
        if (matrix[row][col] == 'V') {
            niceKidsWithPresents++;
            niceKidsWithoutPresents--;
            presents--;
            totalGivenPresents++;
        } else if (matrix[row][col] == 'C') {
            happyCookiePresentGiveaway(row - 1, col);
            happyCookiePresentGiveaway(row + 1, col);
            happyCookiePresentGiveaway(row, col - 1);
            happyCookiePresentGiveaway(row, col + 1);
        }
        matrix[row][col] = 'S';
    }

    private static void happyCookiePresentGiveaway(int row, int col) {
        if (matrix[row][col] == 'V') {
            niceKidsWithPresents++;
            niceKidsWithoutPresents--;
            presents--;
            totalGivenPresents++;
        } else if (matrix[row ][col] == 'X') {
            presents--;
            totalGivenPresents++;
        }
        matrix[row][col] = '-';
    }
}
