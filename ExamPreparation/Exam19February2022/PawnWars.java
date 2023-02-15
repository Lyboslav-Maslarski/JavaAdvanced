package ExamPreparation.Exam19February2022;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int wRow = 0;
        int wCol = 0;
        int bRow = 0;
        int bCol = 0;

        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String line = scan.nextLine();
            if (line.contains("w")) {
                wRow = i;
                wCol = line.indexOf("w");
            }
            if (line.contains("b")) {
                bRow = i;
                bCol = line.indexOf("b");
            }
            board[i] = line.toCharArray();
        }

        boolean wQueen = false;
        boolean bQueen = false;
        boolean wCaptured = false;
        boolean bCaptured = false;

        while (true) {
            if (wRow - 1 == bRow && (wCol - 1 == bCol || wCol + 1 == bCol)) {
                bCaptured = true;
                break;
            }
            wRow--;
            if (wRow == 0) {
                wQueen = true;
                break;
            }
            if (wRow - 1 == bRow && (wCol - 1 == bCol || wCol + 1 == bCol)) {
                wCaptured = true;
                break;
            }
            bRow++;
            if (bRow == 7) {
                bQueen = true;
                break;
            }
        }

        String coordinates;
        if (wQueen) {
            coordinates = getCoordinates(wRow, wCol);
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", coordinates);
        } else if (bQueen) {
            coordinates = getCoordinates(bRow, bCol);
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", coordinates);
        } else if (wCaptured) {
            coordinates = getCoordinates(wRow, wCol);
            System.out.printf("Game over! Black capture on %s.", coordinates);
        } else {
            coordinates = getCoordinates(bRow, bCol);
            System.out.printf("Game over! White capture on %s.", coordinates);
        }
    }

    private static String getCoordinates(int row, int col) {
        char[] colCoordinates = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] rowCoordinates = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        return "" + colCoordinates[col] + rowCoordinates[row];
    }
}
