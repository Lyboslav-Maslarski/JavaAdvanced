package ExamPreparation.Exam20February2021;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[dimensions][dimensions];

        String[] commands = scan.nextLine().split(",");

        int bombCounter = 0;
        int sapperRow = 0;
        int sapperCol = 0;
        boolean hasReachedEnd = false;

        for (int i = 0; i < dimensions; i++) {
            String line = scan.nextLine().replace(" ", "");
            if (line.contains("s")) {
                sapperRow = i;
                sapperCol = line.indexOf("s");
            }
            if (line.contains("B")) {
                for (char c : line.toCharArray()) {
                    if (c == 'B') {
                        bombCounter++;
                    }
                }
            }
            matrix[i] = line.toCharArray();
        }
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("left")) {
                if (sapperCol - 1 < 0) {
                    continue;
                } else if (matrix[sapperRow][sapperCol - 1] == 'e') {
                    hasReachedEnd = true;
                    break;
                } else if (matrix[sapperRow][sapperCol - 1] == 'B') {
                    bombCounter--;
                    System.out.println("You found a bomb!");
                }
                matrix[sapperRow][sapperCol - 1] = 's';
                matrix[sapperRow][sapperCol] = '+';
                sapperCol--;
            } else if (command.equals("right")) {
                if (sapperCol + 1 == dimensions) {
                    continue;
                } else if (matrix[sapperRow][sapperCol + 1] == 'e') {
                    hasReachedEnd = true;
                    break;
                } else if (matrix[sapperRow][sapperCol + 1] == 'B') {
                    bombCounter--;
                    System.out.println("You found a bomb!");
                }
                matrix[sapperRow][sapperCol + 1] = 's';
                matrix[sapperRow][sapperCol] = '+';
                sapperCol++;
            } else if (command.equals("up")) {
                if (sapperRow - 1 < 0) {
                    continue;
                } else if (matrix[sapperRow - 1][sapperCol] == 'e') {
                    hasReachedEnd = true;
                    break;
                } else if (matrix[sapperRow - 1][sapperCol] == 'B') {
                    bombCounter--;
                    System.out.println("You found a bomb!");
                }
                matrix[sapperRow - 1][sapperCol] = 's';
                matrix[sapperRow][sapperCol] = '+';
                sapperRow--;
            } else if (command.equals("down")) {
                if (sapperRow + 1 == dimensions) {
                    continue;
                } else if (matrix[sapperRow + 1][sapperCol] == 'e') {
                    hasReachedEnd = true;
                    break;
                } else if (matrix[sapperRow + 1][sapperCol] == 'B') {
                    bombCounter--;
                    System.out.println("You found a bomb!");
                }
                matrix[sapperRow + 1][sapperCol] = 's';
                matrix[sapperRow][sapperCol] = '+';
                sapperRow++;
            }

            if (bombCounter == 0) {
                break;
            }
        }

        if (bombCounter == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (hasReachedEnd) {
            System.out.println("END! " + bombCounter + " bombs left on the field");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter, sapperRow, sapperCol);
        }
    }
}
