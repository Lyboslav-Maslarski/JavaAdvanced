package ExamPreparation.Exam25June2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    static int row = 0;
    static int col = 0;
    static int money = 0;
    static char[][] matrix;
    static boolean arrested = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());
        List<String> commands = Arrays.stream(scan.nextLine().split(",")).collect(Collectors.toList());

        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine().replace(" ", "");
            if (line.contains("D")) {
                row = i;
                col = line.indexOf("D");
            }
            matrix[i] = line.toCharArray();
        }

        for (String command : commands) {
            if ("up".equals(command)) {
                movePlayer(-1, 0);
            } else if ("down".equals(command)) {
                movePlayer(1, 0);
            } else if ("left".equals(command)) {
                movePlayer(0, -1);
            } else if ("right".equals(command)) {
                movePlayer(0, 1);
            }
            if (arrested) {
                break;
            }
        }

        if (!arrested) {
            System.out.println("Your last theft has finished successfully with " + money + "$ in your pocket.");
        }
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        if (checkNewIndeces(row + rowMutator, col + colMutator)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }
        matrix[row][col] = '+';
        row += rowMutator;
        col += colMutator;
        if (matrix[row][col] == '$') {
            int stolenMoney = row * col;
            money += stolenMoney;
            System.out.println("You successfully stole " + stolenMoney + "$.");
        } else if (matrix[row][col] == 'P') {
            System.out.println("You got caught with " + money + "$, and you are going to jail.");
            matrix[row][col] = '#';
            arrested = true;
            return;
        }
        matrix[row][col] = 'D';
    }

    private static boolean checkNewIndeces(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
