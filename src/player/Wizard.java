package player;

import abilities.Deflect;
import abilities.Drain;
import misc.Cell;
import misc.Constants;
import misc.Map;

public final class Wizard extends Player {
    private Drain drain;
    private Deflect deflect;
    static final int HP = 400;
    static final int HP_LEVEL_UP_MODIFIER = 30;
    private static final float PYRO_DRAIN_MODIFIER = 0.9f;
    private static final float PYRO_DEFLECT_MODIFIER = 1.3f;
    private static final float KNIGHT_DRAIN_MODIFIER = 1.2f;
    private static final float KNIGHT_DEFLECT_MODIFIER = 1.4f;
    private static final float ROGUE_DRAIN_MODIFIER = 0.8f;
    private static final float ROGUE_DEFLECT_MODIFIER = 1.2f;
    private static final float WIZARD_DRAIN_MODIFIER = 1.05f;
    Wizard() {
        super();
        this.setType("W");
        this.setFavorableTerrain("D");
        this.setHp(HP);
        this.setMaxHp(HP);
        this.drain = new Drain(this);
        this.deflect = new Deflect(this);
    }
    @Override
    public void levelUp() {
        this.level++;
        System.out.println(this + " has advanced to level " + this.level);
        this.maxHp = this.HP + this.getLevel() * HP_LEVEL_UP_MODIFIER;
        this.hp = this.maxHp;
        System.out.println(this + " has regenerated their hp to " + this.maxHp);
    }
    @Override
    public void isAttackedBy(Player player) {
        player.attacks(this);
    }
    @Override
    public void attacks(Knight knight) {
        System.out.println(this + " attacks " + knight);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.drain.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.drain.addModifier(KNIGHT_DRAIN_MODIFIER);
        this.drain.use(knight);
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.deflect.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.deflect.addModifier(KNIGHT_DEFLECT_MODIFIER);
        this.deflect.use(knight);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Pyromancer pyromancer) {
        System.out.println(this + " attacks " + pyromancer);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.drain.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.drain.addModifier(PYRO_DRAIN_MODIFIER);
        this.drain.use(pyromancer);
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.deflect.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.deflect.addModifier(PYRO_DEFLECT_MODIFIER);
        this.deflect.use(pyromancer);
    }
    @Override
    public void attacks(Rogue rogue) {
        System.out.println(this + " attacks " + rogue);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.drain.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.drain.addModifier(ROGUE_DRAIN_MODIFIER);
        this.drain.use(rogue);
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.deflect.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.deflect.addModifier(ROGUE_DEFLECT_MODIFIER);
        this.deflect.use(rogue);
    }
    @Override
    public void attacks(Wizard wizard) {
        System.out.println(this + " attacks " + wizard);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.drain.addModifier(Constants.WIZARD_DESERT_MODIFIER);
        }
        this.drain.addModifier(WIZARD_DRAIN_MODIFIER);
        this.drain.use(wizard);
    }
}
