package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Set<String>> playersWithCards = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] playerWithCards = input.split(": ");
            String player = playerWithCards[0];
            String[] cards = playerWithCards[1].split(", ");
            playersWithCards.putIfAbsent(player, new HashSet<>());
            playersWithCards.get(player).addAll(Arrays.asList(cards));
            input = scan.nextLine();
        }
        playersWithCards.forEach((player, cards) -> {
            int sum = getSum(cards);
            System.out.println(player + ": " + sum);
                }
        );
    }

    private static int getSum(Set<String> cards) {
        int sum = cards.stream().mapToInt(value -> {
                    int cardValue = 0;
                    int cardType = 0;
                    if (value.length() == 3) {
                        cardValue = 10;
                        switch (value.charAt(2)) {
                            case 'S':
                                cardType = 4;
                                break;
                            case 'H':
                                cardType = 3;
                                break;
                            case 'D':
                                cardType = 2;
                                break;
                            case 'C':
                                cardType = 1;
                                break;
                        }
                    } else {
                        switch (value.charAt(1)) {
                            case 'S':
                                cardType = 4;
                                break;
                            case 'H':
                                cardType = 3;
                                break;
                            case 'D':
                                cardType = 2;
                                break;
                            case 'C':
                                cardType = 1;
                                break;
                        }
                        if (Character.isDigit(value.charAt(0))) {
                            cardValue = Integer.parseInt(String.valueOf(value.charAt(0)));
                        } else if (value.charAt(0) == 'J') {
                            cardValue = 11;
                        } else if (value.charAt(0) == 'Q') {
                            cardValue = 12;
                        } else if (value.charAt(0) == 'K') {
                            cardValue = 13;
                        } else if (value.charAt(0) == 'A') {
                            cardValue = 14;
                        }
                    }
                    return cardType * cardValue;
                }
        ).sum();
        return sum;
    }
}
