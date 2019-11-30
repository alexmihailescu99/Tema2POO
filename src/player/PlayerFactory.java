package player;

public final class PlayerFactory {
    private static PlayerFactory instance = null;
    private PlayerFactory() {
        //
    }
    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    public Player createPlayer(final String type) {
        switch (type) {
            case "K": return new Knight();
            case "R": return new Rogue();
            case "P": return new Pyromancer();
            case "W": return new Wizard();
            default: return null;
        }
    }
}
