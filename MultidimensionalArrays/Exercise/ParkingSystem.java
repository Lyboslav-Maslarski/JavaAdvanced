package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] parkingSize = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[][] matrix = new boolean[parkingSize[0]][parkingSize[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = data[0];
            int parkingRow = data[1];
            int parkingCol = data[2];
            boolean rowFull = true;
            for (int col = 0; col < matrix[parkingRow].length; col++) {
                if (!matrix[parkingRow][col]) {
                    rowFull = false;
                    break;
                }
            }
            if (rowFull) {
                System.out.println("Row " + parkingRow + " full");
                input = scan.nextLine();
                continue;
            }
            if (!matrix[parkingRow][parkingCol]) {
                matrix[parkingRow][parkingCol] = true;
            } else {
                int counter = 1;
                while (true) {
                    if (parkingCol - counter > 0 && !matrix[parkingRow][parkingCol - counter]) {
                        matrix[parkingRow][parkingCol - counter] = true;
                        parkingCol -= counter;
                        break;
                    } else if (parkingCol + counter < matrix[parkingRow].length && !matrix[parkingRow][parkingCol + counter]) {
                        matrix[parkingRow][parkingCol + counter] = true;
                        parkingCol += counter;
                        break;
                    }
                    counter++;
                    if (parkingCol + counter >= matrix[parkingRow].length && parkingCol - counter < 1) {
                        break;
                    }
                }

            }
            int distance = Math.abs(entryRow - parkingRow) + parkingCol + 1;
            System.out.println(distance);
            input = scan.nextLine();
        }
    }
}
