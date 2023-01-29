package ExamPreparation.Exam14December2022;

import java.util.Scanner;

public class NavyBattle {
    static int mineCount = 0;
    static int battleshipsCount = 0;
    static int row = 0;
    static int col = 0;
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("S")) {
                row = i;
                col = line.indexOf("S");
            }
            matrix[i] = line.toCharArray();
        }

        String command = scan.nextLine();
        while (mineCount < 3 && battleshipsCount < 3) {
            switch (command) {
                case "up":
                    moveSubmarine(-1, 0);
                    break;
                case "down":
                    moveSubmarine(1, 0);
                    break;
                case "left":
                    moveSubmarine(0, -1);
                    break;
                case "right":
                    moveSubmarine(0, 1);
                    break;
            }

            if (battleshipsCount == 3 || mineCount == 3) {
                break;
            }

            command = scan.nextLine();
        }

        if (battleshipsCount == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
        if (mineCount == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
        }
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void moveSubmarine(int rowMutator, int colMutator) {
        matrix[row][col] = '-';
        row += rowMutator;
        col += colMutator;
        if (matrix[row][col] == 'C') {
            battleshipsCount++;
        } else if (matrix[row][col] == '*') {
            mineCount++;
        }
        matrix[row][col] = 'S';
    }
}
