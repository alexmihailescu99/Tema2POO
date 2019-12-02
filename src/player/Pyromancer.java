package player;

public final class Pyromancer extends Player {
    Pyromancer() {
        super();
        this.setType("P");
        this.setFavorableTerrain("V");
    }
    @Override
    public void levelUp() {
        //
    }
    @Override
    public void isAttackedBy(Player player) {
        player.attacks(this);
    }
    @Override
    public void attacks(Knight knight) {

    }
    @Override
    public void attacks(Pyromancer pyromancer) {

    }
    @Override
    public void attacks(Rogue rogue) {

    }
    @Override
    public void attacks(Wizard wizard) {

    }
}
