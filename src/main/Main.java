package main;

import player.Player;

public final class Main {
    private Main() {
        //
    }
    public static void main(String[] args) throws java.io.IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Game.getInstance().setGameInput(gameInput);
        Game.getInstance().init();
//        for (Player player : Game.getInstance().getPlayers()) {
//            player.setExp(401);
//            player.update();
//        }
        for (int i = 0; i < Game.getInstance().getRounds(); ++i) {
            for (int j = 0; j < Game.getInstance().getPlayers().size(); ++j) {
                Player currPlayer = Game.getInstance().getPlayers().get(j);
                String currCommand = Game.getInstance().getPlayerCommands().get(0);
                Game.getInstance().getPlayerCommands().remove(currCommand);
                if (currPlayer.getHp() <= 0) {
                    continue;
                }
                if (currPlayer.getCanMove()) {
                    currPlayer.move(currCommand);
                }
            }
            // Check overtime abilities
            Game.getInstance().checkOverTimeAbilities();
            // Check if anyone has died from overtime abilities
            Game.getInstance().checkDead();
            Game.getInstance().checkPositions();
            Game.getInstance().finaliseRound();
        }
        System.out.print(Game.getInstance().printStandings());
        gameInputLoader.write(Game.getInstance().printStandings());
        //Game.getInstance().printStandings();
    }
}
