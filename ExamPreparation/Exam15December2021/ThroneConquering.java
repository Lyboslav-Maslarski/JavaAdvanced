package ExamPreparation.Exam15December2021;

import java.util.Scanner;

public class ThroneConquering {
    static int row;
    static int col;
    static char[][] matrix;
    static int energy;
    static boolean haveWon = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        energy = Integer.parseInt(scan.nextLine());
        int dimensions = Integer.parseInt(scan.nextLine());

        matrix = new char[dimensions][];
        for (int i = 0; i < dimensions; i++) {
            String line = scan.nextLine();
            if (line.contains("P")) {
                row = i;
                col = line.indexOf("P");
            }
            matrix[i] = line.toCharArray();
        }

        String[] commandParts = scan.nextLine().split("\\s+");
        while (energy > 0 && !haveWon) {

            String command = commandParts[0];

            int spawnRow = Integer.parseInt(commandParts[1]);
            int spawnCol = Integer.parseInt(commandParts[2]);
            matrix[spawnRow][spawnCol] = 'S';

            switch (command) {
                case "up":
                    movePlayer(-1, 0);
                    break;
                case "down":
                    movePlayer(1, 0);
                    break;
                case "left":
                    movePlayer(0, -1);
                    break;
                case "right":
                    movePlayer(0, 1);
                    break;
            }
            if (energy <= 0 && !haveWon) {
                matrix[row][col] = 'X';
                break;
            }else if (haveWon){
                matrix[row][col] = '-';
                break;
            }

            commandParts = scan.nextLine().split("\\s+");
        }
        if (haveWon) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        } else {
            System.out.println("Paris died at " + row + ";" + col + ".");
        }
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void movePlayer(int rowMutator, int colMutator) {
        energy--;
        int newRow = row + rowMutator;
        int newCol = col + colMutator;
        if (newRow < 0 || newCol < 0 || newRow == matrix.length || newCol == matrix[newRow].length) {
            return;
        }
        if (matrix[newRow][newCol] == 'S') {
            energy -= 2;
        }
        if (matrix[newRow][newCol] == 'H') {
            haveWon = true;
        }
        matrix[row][col]='-';
        row=newRow;
        col=newCol;
        matrix[row][col]='P';
    }
}
