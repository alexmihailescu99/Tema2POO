package player;

import abilities.Fireblast;
import abilities.Ignite;
import misc.Constants;

public final class Pyromancer extends Player {
    private Fireblast fireblast;
    private Ignite ignite;
    private static final int LEVEL_HP_MODIFIER = 50;
    private static final float ROGUE_FIREBLAST_MODIFIER = 0.8f;
    private static final float ROGUE_IGNITE_MODIFIER = 0.8f;
    private static final float PYRO_FIREBLAST_MODIFIER = 0.9f;
    private static final float PYRO_IGNITE_MODIFIER = 0.9f;
    private static final float KNIGHT_FIREBLAST_MODIFIER = 1.2f;
    private static final float KNIGHT_IGNITE_MODIFIER = 1.2f;
    private static final float WIZARD_FIREBLAST_MODIFIER = 1.05f;
    private static final float WIZARD_IGNITE_MODIFIER = 1.05f;
    Pyromancer() {
        super();
        this.setType("P");
        this.setFavorableTerrain("V");
        this.setHp(Constants.PYROMANCER_HP);
        this.setMaxHp(Constants.PYROMANCER_HP);
        this.fireblast = new Fireblast(this);
        this.ignite = new Ignite(this);
    }
    @Override
    public void levelUp() {
        this.level++;
        System.out.println(this + " has advanced to level " + this.level);
        this.maxHp = Constants.PYROMANCER_HP + this.getLevel() * LEVEL_HP_MODIFIER;
        this.hp = this.maxHp;
        System.out.println(this + " has regenerated their hp to " + this.maxHp);
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
