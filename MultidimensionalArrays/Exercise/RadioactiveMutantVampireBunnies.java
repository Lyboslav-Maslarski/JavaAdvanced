package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[dimensions[0]][];
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().toCharArray();
            if (Arrays.toString(matrix[i]).contains("P")) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'P') {
                        playerRow = i;
                        playerCol = j;
                    }
                }
            }
        }
        boolean isAlive = true;
        boolean haveWon = false;
        char[] commands = scan.nextLine().toCharArray();
        for (int i = 0; i < commands.length; i++) {
            char currentCommand = commands[i];
            if (currentCommand == 'R') {
                if (playerCol == matrix[playerRow].length - 1) {
                    matrix[playerRow][playerCol] = '.';
                    haveWon = true;
                } else {
                    if (matrix[playerRow][playerCol + 1] == 'B') {
                        isAlive = false;
                    } else {
                        matrix[playerRow][playerCol + 1] = 'P';
                    }
                    matrix[playerRow][playerCol] = '.';
                    playerCol++;
                }
            } else if (currentCommand == 'L') {
                if (playerCol == 0) {
                    matrix[playerRow][playerCol] = '.';
                    haveWon = true;
                } else {
                    if (matrix[playerRow][playerCol - 1] == 'B') {
                        isAlive = false;
                    } else {
                        matrix[playerRow][playerCol - 1] = 'P';
                    }
                    matrix[playerRow][playerCol] = '.';
                    playerCol--;
                }
            } else if (currentCommand == 'U') {
                if (playerRow == 0) {
                    matrix[playerRow][playerCol] = '.';
                    haveWon = true;
                } else {
                    if (matrix[playerRow - 1][playerCol] == 'B') {
                        isAlive = false;
                    } else {
                        matrix[playerRow - 1][playerCol] = 'P';
                    }
                    matrix[playerRow][playerCol] = '.';
                    playerRow--;
                }
            } else if (currentCommand == 'D') {
                if (playerRow == matrix.length - 1) {
                    matrix[playerRow][playerCol] = '.';
                    haveWon = true;
                } else {
                    if (matrix[playerRow + 1][playerCol] == 'B') {
                        isAlive = false;
                    } else {
                        matrix[playerRow + 1][playerCol] = 'P';
                    }
                    matrix[playerRow][playerCol] = '.';
                    playerRow++;
                }
            }

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B') {
                        if (row - 1 >= 0) {
                            if (matrix[row - 1][col] == 'P') {
                                matrix[row - 1][col] = 'N';
                                isAlive = false;
                            }
                            if (matrix[row - 1][col] == '.') {
                                matrix[row - 1][col] = 'N';
                            }
                        }
                        if (col - 1 >= 0) {
                            if (matrix[row][col - 1] == 'P') {
                                matrix[row][col - 1] = 'N';
                                isAlive = false;
                            }
                            if (matrix[row][col - 1] == '.') {
                                matrix[row][col - 1] = 'N';
                            }
                        }
                        if (row + 1 < matrix.length) {
                            if (matrix[row + 1][col] == 'P') {
                                matrix[row + 1][col] = 'N';
                                isAlive = false;
                            }
                            if (matrix[row + 1][col] == '.') {
                                matrix[row + 1][col] = 'N';
                            }
                        }
                        if (col + 1 < matrix[row].length) {
                            if (matrix[row][col + 1] == 'P') {
                                matrix[row][col + 1] = 'N';
                                isAlive = false;
                            }
                            if (matrix[row][col + 1] == '.') {
                                matrix[row][col + 1] = 'N';
                            }
                        }
                    }
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'N') {
                        matrix[row][col] = 'B';
                    }
                }
            }
            if (haveWon) {
                isAlive = true;
                break;
            }
            if (!isAlive) {
                break;
            }
        }
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }

        System.out.println(isAlive ? "won: " + playerRow + " " + playerCol : "dead: " + playerRow + " " + playerCol);
    }
}
