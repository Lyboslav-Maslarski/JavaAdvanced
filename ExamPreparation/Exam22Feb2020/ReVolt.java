package ExamPreparation.Exam22Feb2020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());
        int playerRow = 0;
        int playerCol = 0;
        boolean hasWon = false;

        char[][] matrix = new char[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) {
            String currentRow = scan.nextLine();
            if (currentRow.contains("f")) {
                playerRow = i;
                playerCol = currentRow.indexOf('f');
            }
            matrix[i] = currentRow.toCharArray();
        }
        for (int i = 0; i < countCommands; i++) {
            String command = scan.nextLine();

            if (command.equals("up")) {

                matrix[playerRow][playerCol] = '-';

                if (playerRow == 0) {
                    playerRow = dimensions - 1;
                } else {
                    playerRow--;
                }

                if (matrix[playerRow][playerCol] == 'B') {

                    if (playerRow == 0) {
                        playerRow = dimensions - 1;
                    } else {
                        playerRow--;
                    }
                } else if (matrix[playerRow][playerCol] == 'T') {

                    if (playerRow == dimensions - 1) {
                        playerRow = 0;
                    } else {
                        playerRow++;
                    }
                }

                if (matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                }

                matrix[playerRow][playerCol] = 'f';

                if (hasWon) {
                    break;
                }

            } else if (command.equals("down")) {

                matrix[playerRow][playerCol] = '-';

                if (playerRow == dimensions - 1) {
                    playerRow = 0;
                } else {
                    playerRow++;
                }

                if (matrix[playerRow][playerCol] == 'B') {

                    if (playerRow == dimensions - 1) {
                        playerRow = 0;
                    } else {
                        playerRow++;
                    }
                } else if (matrix[playerRow][playerCol] == 'T') {

                    if (playerRow == 0) {
                        playerRow = dimensions - 1;
                    } else {
                        playerRow--;
                    }
                }

                if (matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                }

                matrix[playerRow][playerCol] = 'f';

                if (hasWon) {
                    break;
                }

            } else if (command.equals("left")) {

                matrix[playerRow][playerCol] = '-';

                if (playerCol == 0) {
                    playerCol = dimensions - 1;
                } else {
                    playerCol--;
                }

                if (matrix[playerRow][playerCol] == 'B') {

                    if (playerCol == 0) {
                        playerCol = dimensions - 1;
                    } else {
                        playerCol--;
                    }
                } else if (matrix[playerRow][playerCol] == 'T') {

                    if (playerCol == dimensions - 1) {
                        playerCol = 0;
                    } else {
                        playerCol++;
                    }
                }

                if (matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                }

                matrix[playerRow][playerCol] = 'f';

                if (hasWon) {
                    break;
                }

            } else if (command.equals("right")) {

                matrix[playerRow][playerCol] = '-';

                if (playerCol == dimensions - 1) {
                    playerCol = 0;
                } else {
                    playerCol++;
                }

                if (matrix[playerRow][playerCol] == 'B') {

                    if (playerCol == dimensions - 1) {
                        playerCol = 0;
                    } else {
                        playerCol++;
                    }
                } else if (matrix[playerRow][playerCol] == 'T') {

                    if (playerCol == 0) {
                        playerCol = dimensions - 1;
                    } else {
                        playerCol--;
                    }
                }

                if (matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                }

                matrix[playerRow][playerCol] = 'f';

                if (hasWon) {
                    break;
                }
            }
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }
}
