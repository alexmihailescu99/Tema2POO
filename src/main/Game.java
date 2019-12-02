package main;

import misc.Map;
import player.Player;
import player.PlayerFactory;
import player.Wizard;

import java.util.ArrayList;

final class Game {
    private static Game instance = null;
    private ArrayList<Player> players;
    private GameInput gameInput;
    private int rounds;
    private int noPlayers;

    ArrayList<String> getPlayerCommands() {
        return playerCommands;
    }

    // This will hold the map cell types
    private ArrayList<ArrayList<String>> cellTypes;
    // This will hold the player information(race, positions)
    private ArrayList<String> playerInfo;
    private ArrayList<String> playerCommands;
    private Game() {
    }
    // Initializes map dimensions
    // INSTANCE NEEDS TO HAVE GAMEINPUT SET BEFORE CALLING IT
    void init() {
        players = new ArrayList<>();
        rounds = gameInput.getRounds();
        noPlayers = gameInput.getNoPlayers();
        cellTypes = gameInput.getCellTypes();
        // Initialise and create the map
        Map.getInstance().setXSize(gameInput.getXMapSize());
        Map.getInstance().setYSize(gameInput.getYMapSize());
        Map.getInstance().createCellMap();
        Map.getInstance().setCellTypes(cellTypes);
        playerInfo = gameInput.getPlayerInfo();
        for (int i = 0; i < playerInfo.size(); ++i) {
            String str = playerInfo.get(i);
            String[] splitted = str.split(" ", 0);
            Player currPlayer = PlayerFactory.getInstance().createPlayer(splitted[0]);
            assert currPlayer != null;
            currPlayer.setId(i);
            currPlayer.setXPos(Integer.parseInt(splitted[1]));
            currPlayer.setYPos(Integer.parseInt(splitted[2]));
            players.add(currPlayer);
        }
        playerCommands = gameInput.getPlayerCommands();
    }

    void setGameInput(GameInput gameInputVal) {
        gameInput = gameInputVal;
    }
    static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    ArrayList<Player> getPlayers() {
        return players;
    }

    int getRounds() {
        return rounds;
    }

    void checkPositions() {
        for (int i = 0; i < players.size(); ++i) {
            Player firstPlayer = players.get(i);
            for (int j = i + 1; j < players.size(); ++j) {
                Player secondPlayer = players.get(j);
                if (firstPlayer.getXPos() == secondPlayer.getXPos()
                && firstPlayer.getYPos() == secondPlayer.getYPos()
                && firstPlayer.getHp() > 0 && secondPlayer.getHp() > 0) {
                    // Make sure the wizard always attacks first
                    // So he has damage to deflect
                    if (secondPlayer instanceof Wizard
                    && !(firstPlayer instanceof Wizard)) {
                        Player temp = secondPlayer;
                        secondPlayer = firstPlayer;
                        firstPlayer = temp;
                    }
                    secondPlayer.isAttackedBy(firstPlayer);
                    firstPlayer.isAttackedBy(secondPlayer);
                }
            }
        }
    }

    void checkOverTimeAbilities() {
        for (Player player : players) {
            // If the player has an overtime effect
            if (player.getCurrOverTimeAbility() != null) {
                // Apply it
                player.getCurrOverTimeAbility().applyOverTimeEffects();
            }
        }
    }
    void kill(Player player) {
        player.setXPos(-1);
        player.setYPos(-1);
        player.setExp(0);
        player.setDead(true);
        player.setCurrOverTimeAbility(null);
    }
    void checkDead() {
        for (Player player : players) {
            if (player.getHp() <= 0) {
                kill(player);
            }
        }
    }
    void finaliseRound() {
        // Check if anyone has died
        checkDead();
        for (Player player : players) {
            if (!player.getIsDead()) {
                // Substract from the remaining overtime effect rounds
                player.setOverTimeAbilityRemainingRounds(
                        player.getOverTimeAbilityRemainingRounds() - 1);
                if (player.getOverTimeAbilityRemainingRounds() < 0) {
                    player.setOverTimeAbilityRemainingRounds(0);
                }
                // Update max hp if necessary
                // Remove overtime effect if necessary
                player.update();
            }
        }
    }

    void printStandings() {
        for (Player player : players) {
            if (!player.getIsDead()) {
                System.out.println(player.getType() + " " + player.getLevel()
                + " " + player.getExp() + " " + player.getHp() + " "
                        + player.getXPos() + " " + player.getYPos());
            } else {
                System.out.println(player.getType() + " dead");
            }
        }
    }
}
