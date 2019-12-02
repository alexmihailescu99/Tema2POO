package main;

import player.Player;

public final class Main {
    private Main() {
        //
    }
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader("/home/alex/Videos/Tema2POO/mata.txt",
                "/home/alex/Videos/Tema2POO/mata2.txt");
        GameInput gameInput = gameInputLoader.load();
        Game.getInstance().setGameInput(gameInput);
        Game.getInstance().init();
        for (Player player : Game.getInstance().getPlayers()) {
            player.setExp(401);
            player.update();
        }
        for (int i = 0; i < Game.getInstance().getRounds(); ++i) {
            for (int j = 0; j < Game.getInstance().getPlayers().size(); ++j) {
                Player currPlayer = Game.getInstance().getPlayers().get(j);
                String currCommand = Game.getInstance().getPlayerCommands().get(0);
                Game.getInstance().getPlayerCommands().remove(currCommand);
                if (currPlayer.getHp() <= 0) {
                    System.out.println("Can not move " + currPlayer + " " + currCommand
                    + " since he is dead");
                    continue;
                }
                if (currPlayer.getCanMove()) {
                    currPlayer.move(currCommand);
                    System.out.println("Moved " + currPlayer + " " + currCommand);
                } else {
                    System.out.println(currPlayer + " can not move!");
                }
            }
            // Check overtime abilities
            Game.getInstance().checkOverTimeAbilities();
            // Check if anyone has died from overtime abilities
            Game.getInstance().checkDead();
            Game.getInstance().printStandings();
            Game.getInstance().checkPositions();
            Game.getInstance().finaliseRound();
            Game.getInstance().printStandings();
        }
        for (Player player : Game.getInstance().getPlayers()) {
            System.out.println(player);
        }
        //Game.getInstance().printStandings();
    }
}
