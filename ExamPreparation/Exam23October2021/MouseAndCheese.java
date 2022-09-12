package ExamPreparation.Exam23October2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cheeseEaten = 0;
        int dimensions = Integer.parseInt(scan.nextLine());
        int mouseRow = 0;
        int mouseCol = 0;
        boolean hasLeft = false;
        char[][] matrix = new char[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            String input = scan.nextLine();
            if (input.contains("M")) {
                mouseRow = i;
                mouseCol = input.indexOf("M");
            }
            matrix[i] = input.toCharArray();
        }
        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.equals("up")) {
                if (mouseRow - 1 < 0) {
                    matrix[mouseRow][mouseCol] = '-';
                    hasLeft = true;
                    break;
                } else {
                    if (matrix[mouseRow - 1][mouseCol] == 'c') {
                        mouseRow--;
                        cheeseEaten++;
                    } else if (matrix[mouseRow - 1][mouseCol] == 'B') {
                        matrix[mouseRow - 1][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol] = '-';
                        mouseRow--;
                        continue;
                    } else {
                        mouseRow--;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    matrix[mouseRow + 1][mouseCol] = '-';
                }
            } else if (command.equals("down")) {
                if (mouseRow + 1 == dimensions) {
                    matrix[mouseRow][mouseCol] = '-';
                    hasLeft = true;
                    break;
                } else {
                    if (matrix[mouseRow + 1][mouseCol] == 'c') {
                        mouseRow++;
                        cheeseEaten++;
                    } else if (matrix[mouseRow + 1][mouseCol] == 'B') {
                        matrix[mouseRow + 1][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol] = '-';
                        mouseRow++;
                        continue;
                    } else {
                        mouseRow++;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    matrix[mouseRow - 1][mouseCol] = '-';
                }
            } else if (command.equals("left")) {
                if (mouseCol - 1 < 0) {
                    matrix[mouseRow][mouseCol] = '-';
                    hasLeft = true;
                    break;
                } else {
                    if (matrix[mouseRow][mouseCol - 1] == 'c') {
                        mouseCol--;
                        cheeseEaten++;
                    } else if (matrix[mouseRow][mouseCol - 1] == 'B') {
                        matrix[mouseRow][mouseCol - 1] = 'M';
                        matrix[mouseRow][mouseCol] = '-';
                        mouseCol--;
                        continue;
                    } else {
                        mouseCol--;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    matrix[mouseRow][mouseCol + 1] = '-';
                }
            } else if (command.equals("right")) {
                if (mouseCol + 1 == dimensions) {
                    matrix[mouseRow][mouseCol] = '-';
                    hasLeft = true;
                    break;
                } else {
                    if (matrix[mouseRow][mouseCol + 1] == 'c') {
                        mouseCol++;
                        cheeseEaten++;
                    } else if (matrix[mouseRow][mouseCol + 1] == 'B') {
                        matrix[mouseRow][mouseCol + 1] = 'M';
                        matrix[mouseRow][mouseCol] = '-';
                        mouseCol++;
                        continue;
                    } else {
                        mouseCol++;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    matrix[mouseRow][mouseCol - 1] = '-';
                }
            }
            command = scan.nextLine();
        }
        if (hasLeft) {
            System.out.println("Where is the mouse?");
        }
        if (cheeseEaten >= 5) {
            System.out.println("Great job, the mouse is fed " + cheeseEaten + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheeseEaten) + " cheeses more.");
        }
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }
}
