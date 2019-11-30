package misc;

public class Map {
    private static Map instance = null;
    public final Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }
}
