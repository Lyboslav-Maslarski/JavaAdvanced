package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double heiganHp = 3000000;
        int playerHP = 18500;

        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";

        boolean cloudEffect = false;
        double playerDmg = Double.parseDouble(scan.nextLine());

        while (playerHP > 0) {
            String[] data = scan.nextLine().split("\\s+");
            heiganHp -= playerDmg;
            if (cloudEffect) {
                playerHP -= 3500;
                cloudEffect = false;
            }
            if (playerHP <= 0) {
                break;
            }
            if (heiganHp <= 0) {
                break;
            }
            String spell = data[0];
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);
            if (inDmgArea(row, col, playerRow, playerCol)) {
                if (!inDmgArea(row, col, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!inDmgArea(row, col, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!inDmgArea(row, col, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!inDmgArea(row, col, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    switch (data[0]) {
                        case "Cloud":
                            playerHP -= 3500;
                            cloudEffect = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHP -= 6000;
                            lastSpell = "Eruption";
                            break;
                    }
                }
            }


        }


        if (heiganHp > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHp);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHP > 0) {
            System.out.println("Player: " + playerHP);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isWall(int moved) {
        return 0 > moved || moved >= 15;
    }

    private static boolean inDmgArea(int row, int col, int playerRow, int playerCol) {
        return row - 1 <= playerRow && playerRow <= row + 1 && col - 1 <= playerCol && playerCol <= col + 1;
    }
}
