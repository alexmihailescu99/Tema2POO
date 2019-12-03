package main;

import java.io.FileWriter;
import java.util.ArrayList;
import fileio.FileSystem;

final class GameInputLoader {
    private final String inputPath;
    private final String outputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    GameInput load() {
        int xMapSize = 0;
        int yMapSize = 0;
        int rounds = 0;
        int noPlayers = 0;
        // This will hold the map cell types
        ArrayList<ArrayList<String>> cellTypes = new ArrayList<>();
        // This will hold the player information(race, positions)
        ArrayList<String> playerInfo = new ArrayList<>();
        ArrayList<String> playerCommands = new ArrayList<>();

        String playerInfoRow; // something like RACE xPos yPos

        try {
            FileSystem fs = new FileSystem(inputPath, outputPath);
            // Read the dimensions of the map
            xMapSize = fs.nextInt();
            yMapSize = fs.nextInt();
            // Populate the CellTypes matrix
            for (int i = 0; i < xMapSize; ++i) {
                cellTypes.add(new ArrayList<>());
                String myCell = fs.nextWord();
                String[] splittedStr = myCell.split("", 0);
                for (int j = 0; j < yMapSize; ++j) {
                    cellTypes.get(i).add(splittedStr[j]);
                }
            }
            noPlayers = fs.nextInt();
            for (int i = 0; i < noPlayers; ++i) {
                String playerRace = fs.nextWord();
                String playerXPos = fs.nextWord();
                String playerYPos = fs.nextWord();
                String playerTotalInfo = playerRace + " "
                        + playerXPos + " " + playerYPos;
                playerInfo.add(playerTotalInfo);
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                String cmd = fs.nextWord();
                String[] splitted = cmd.split("", 0);
                for (int j = 0; j < noPlayers; ++j) {
                    playerCommands.add(splitted[j]);
                }
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new GameInput(xMapSize, yMapSize, cellTypes,
                noPlayers, playerInfo, rounds, playerCommands);
    }

    public void write(final String str) {
        try {
            FileWriter out = new FileWriter(outputPath);
            out.write(str);
            out.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
