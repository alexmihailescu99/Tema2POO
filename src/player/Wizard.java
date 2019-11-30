package player;

public final class Wizard extends Player {
    Wizard() {
        super();
        this.setType("W");
        this.setFavorableTerrain("D");
    }
    @Override
    public void isAttackedBy(Player player) {
        player.attacks(this);
    }
    @Override
    public void attacks(Knight knight) {
        System.out.println(this + " attacks " + knight);
    }
    @Override
    public void attacks(Pyromancer pyromancer) {

    }
    @Override
    public void attacks(Rogue rogue) {

    }
    @Override
    public void attacks(Wizard wizard) {
        System.out.println(this + " attacks " + wizard);
    }
}
