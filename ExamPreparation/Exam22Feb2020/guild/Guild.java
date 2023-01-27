package ExamPreparation.Exam22Feb2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> players;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (players.size() < capacity) {
            players.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return players.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        players.stream().filter(player -> player.getName().equals(name)).findFirst().ifPresent(playerToPromote -> playerToPromote.setRank("Member"));
    }

    public void demotePlayer(String name) {
        players.stream().filter(player -> player.getName().equals(name)).findFirst().ifPresent(playerToPromote -> playerToPromote.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playerList = new ArrayList<>();
        for (Player player : players) {
            if (player.getClazz().equals(clazz)) {
                playerList.add(player);
            }
        }
        players.removeAll(playerList);
        Player[] playersToReturn = new Player[playerList.size()];
        for (int i = 0; i < playerList.size(); i++) {
            playersToReturn[i] = playerList.get(i);
        }
        return playersToReturn;
    }

    public int count() {
        return players.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the ExamPreparation.Exam22Feb2020.guild: ").append(name).append(":");
        for (Player player : players) {
            sb.append(System.lineSeparator()).append(player);
        }
        return sb.toString();
    }
}
