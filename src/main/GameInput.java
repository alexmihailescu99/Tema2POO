package main;

import java.util.ArrayList;

// THE CLASS DOES NOT HAVE A NO PARAMETER CONSTRUCTOR
public final class GameInput {
    private int xMapSize;
    private int yMapSize;
    private int rounds;
    private int noPlayers;
    // This will hold the map cell types
    private ArrayList<ArrayList<String>> cellTypes;
    // This will hold the player information(race, positions)
    private ArrayList<String> playerInfo;
    private ArrayList<String> playerCommands;


    GameInput(final int xMapSize, final int yMapSize,
              final ArrayList<ArrayList<String>> cellTypes,
              final int noPlayers, final ArrayList<String> playerInfo, final int rounds,
              final ArrayList<String> playerCommands) {
        this.xMapSize = xMapSize;
        this.yMapSize = yMapSize;
        this.cellTypes = new ArrayList<>(cellTypes);
        this.noPlayers = noPlayers;
        this.playerInfo = new ArrayList<>(playerInfo);
        this.rounds = rounds;
        this.playerCommands = new ArrayList<>(playerCommands);
    }
    int getXMapSize() {
        return xMapSize;
    }

    public void setXMapSize(final int xMapSizeVal) {
        this.xMapSize = xMapSizeVal;
    }

    int getYMapSize() {
        return yMapSize;
    }

    public void setYMapSize(final int yMapSizeVal) {
        this.yMapSize = yMapSizeVal;
    }

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }

    int getNoPlayers() {
        return noPlayers;
    }

    public void setNoPlayers(final int noPlayers) {
        this.noPlayers = noPlayers;
    }

    ArrayList<ArrayList<String>> getCellTypes() {
        return cellTypes;
    }

    public void setCellTypes(final ArrayList<ArrayList<String>> cellTypes) {
        this.cellTypes = cellTypes;
    }

    ArrayList<String> getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(final ArrayList<String> playerInfo) {
        this.playerInfo = playerInfo;
    }

    public ArrayList<String> getPlayerCommands() {
        return playerCommands;
    }

    public void setPlayerCommands(final ArrayList<String> playerCommands) {
        this.playerCommands = playerCommands;
    }
    int getRounds() {
        return this.rounds;
    }
}
