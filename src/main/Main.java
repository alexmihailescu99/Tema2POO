package main;

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
        for (int i = 0; i < Game.getInstance().getRounds(); ++i) {
            for (int j = 0; j < Game.getInstance().getPlayers().size(); ++j) {
                System.out.println(Game.getInstance().getPlayers().get(j));
            }
        }
    }
}
