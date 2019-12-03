package player;

import abilities.Fireblast;
import abilities.Ignite;
import misc.Cell;
import misc.Constants;
import misc.Map;

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
        this.maxHp = Constants.PYROMANCER_HP + this.getLevel() * LEVEL_HP_MODIFIER;
        this.hp = this.maxHp;
    }
    @Override
    public void isAttackedBy(final Player player) {
        player.attacks(this);
    }
    @Override
    public void attacks(final Knight knight) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.fireblast.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }
        this.fireblast.addModifier(KNIGHT_FIREBLAST_MODIFIER);
        this.fireblast.use(knight);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
        if (knight.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.ignite.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }

        this.ignite.addModifier(KNIGHT_IGNITE_MODIFIER);
        this.ignite.use(knight);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.modifiers.clear();
    }
    @Override
    public void attacks(final Pyromancer pyromancer) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.fireblast.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }
        this.fireblast.addModifier(PYRO_FIREBLAST_MODIFIER);
        this.fireblast.use(pyromancer);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
        if (pyromancer.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.ignite.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }

        this.ignite.addModifier(PYRO_IGNITE_MODIFIER);
        this.ignite.use(pyromancer);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.modifiers.clear();
    }
    @Override
    public void attacks(final Rogue rogue) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.fireblast.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }
        this.fireblast.addModifier(ROGUE_FIREBLAST_MODIFIER);
        this.fireblast.use(rogue);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
        if (rogue.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.ignite.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }

        this.ignite.addModifier(ROGUE_IGNITE_MODIFIER);
        this.ignite.use(rogue);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.modifiers.clear();
    }
    @Override
    public void attacks(final Wizard wizard) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.fireblast.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }
        this.fireblast.addModifier(WIZARD_FIREBLAST_MODIFIER);
        int dmg1 = this.fireblast.use(wizard);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
        if (wizard.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.ignite.addModifier(Constants.PYRO_VOLCANIC_MODIFIER);
        }

        this.ignite.addModifier(WIZARD_IGNITE_MODIFIER);
        int dmg2 = this.ignite.use(wizard);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.dmg = dmg1 + dmg2;
        this.modifiers.clear();
    }
}
