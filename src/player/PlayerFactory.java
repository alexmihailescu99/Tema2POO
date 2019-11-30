package player;

final class PlayerFactory {
    private static PlayerFactory instance = null;
    private PlayerFactory() {
        //
    }
    static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    Player createPlayer(final char type) {
        switch (type) {
            case 'K': return new Knight();
            case 'R': return new Rogue();
            case 'P': return new Pyromancer();
            case 'W': return new Wizard();
            default: return null;
        }
    }
}
