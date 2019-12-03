package player;

import abilities.Backstab;
import abilities.Paralysis;
import misc.Cell;
import misc.Constants;
import misc.Map;

public final class Rogue extends Player {
    static final int LEVEL_HP_MODIFIER = 40;
    private Backstab backstab;
    private Paralysis paralysis;
    private static final float ROGUE_BACKSTAB_MODIFIER = 1.2f;
    private static final float ROGUE_PARALYSIS_MODIFIER = 0.9f;
    private static final float PYRO_BACKSTAB_MODIFIER = 1.25f;
    private static final float PYRO_PARALYSIS_MODIFIER = 1.2f;
    private static final float KNIGHT_BACKSTAB_MODIFIER = 0.9f;
    private static final float KNIGHT_PARALYSIS_MODIFIER = 0.8f;
    private static final float WIZARD_BACKSTAB_MODIFIER = 1.25f;
    private static final float WIZARD_PARALYSIS_MODIFIER = 1.25f;
    private static final float BACKSTAB_CRITICAL_MODIFIER = 1.5f;
    private static final float BACKSTAB_CRITICAL_MAX_COUNT = 4;
    private boolean criticalHit;
    private int backstabCounter;
    Rogue() {
        super();
        this.setType("R");
        this.setFavorableTerrain("W");
        this.setHp(Constants.ROGUE_HP);
        this.setMaxHp(Constants.ROGUE_HP);
        this.backstab = new Backstab(this);
        this.paralysis = new Paralysis(this);
        this.backstabCounter = 0;
        this.criticalHit = false;
    }
    @Override
    public void levelUp() {
        this.level++;
        System.out.println(this + " has advanced to level " + this.level);
        this.maxHp = Constants.ROGUE_HP + this.getLevel() * LEVEL_HP_MODIFIER;
        this.hp = this.maxHp;
        System.out.println(this + " has regenerated their hp to " + this.maxHp);
    }
    @Override
    public void isAttackedBy(Player player) {
        player.attacks(this);
    }
    @Override
    public void attacks(Knight knight) {
        if (this.getBackstabCounter() == 0) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
            }
            this.backstabCounter = 1;
        }
        System.out.println(this + " attacks " + knight);
        if (this.getBackstabCounter() == BACKSTAB_CRITICAL_MAX_COUNT) {
            if (this.getCellPosition().getType().equals(
                this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
            }
            this.setBackstabCounter(1);
        }
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.backstab.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.backstab.addModifier(KNIGHT_BACKSTAB_MODIFIER);
        this.backstab.use(knight);
        this.backstabCounter++;
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.paralysis.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.paralysis.addModifier(KNIGHT_PARALYSIS_MODIFIER);
        this.paralysis.use(knight);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Pyromancer pyromancer) {
        if (this.getBackstabCounter() == 0) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
            }
            this.backstabCounter = 1;
        }
        System.out.println(this + " attacks " + pyromancer);
        if (this.getBackstabCounter() == BACKSTAB_CRITICAL_MAX_COUNT) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
            }
            this.setBackstabCounter(1);
        }
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.backstab.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.backstab.addModifier(PYRO_BACKSTAB_MODIFIER);
        this.backstab.use(pyromancer);
        this.backstabCounter++;
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.paralysis.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.paralysis.addModifier(PYRO_PARALYSIS_MODIFIER);
        this.paralysis.use(pyromancer);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Rogue rogue) {
        if (this.getBackstabCounter() == 0) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
            }
            this.backstabCounter = 1;
        }
        System.out.println(this + " attacks " + rogue);
        if (this.getBackstabCounter() == BACKSTAB_CRITICAL_MAX_COUNT) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
            }
            this.setBackstabCounter(1);
        }
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.backstab.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.backstab.addModifier(ROGUE_BACKSTAB_MODIFIER);
        this.backstab.use(rogue);
        this.backstabCounter++;
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.paralysis.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.paralysis.addModifier(ROGUE_PARALYSIS_MODIFIER);
        this.paralysis.use(rogue);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Wizard wizard) {
        if (this.getBackstabCounter() == 0) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
                this.criticalHit = true;
            }
            this.backstabCounter = 1;
        }
        System.out.println(this + " attacks " + wizard);
        if (this.getBackstabCounter() == BACKSTAB_CRITICAL_MAX_COUNT) {
            if (this.getCellPosition().getType().equals(
                    this.getFavorableTerrain())) {
                this.backstab.addModifier(BACKSTAB_CRITICAL_MODIFIER);
                this.criticalHit = true;
            }
            this.setBackstabCounter(1);
        }
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.backstab.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.backstab.addModifier(WIZARD_BACKSTAB_MODIFIER);
        boolean wasAlreadyDead = false;
        int dmg1 = this.backstab.use(wizard);
        if (wizard.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        int prevExp = this.getExp();
        this.backstabCounter++;
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.paralysis.addModifier(Constants.ROGUE_WOODS_MODIFIER);
        }
        this.paralysis.addModifier(WIZARD_PARALYSIS_MODIFIER);
        int dmg2 = this.paralysis.use(wizard);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.dmg = dmg1 + dmg2;
        System.out.println(" I am adding " + dmg1 + " " + dmg2);
        System.out.println(this + " "  + this.dmg  + " dmg without modifiers");
        this.criticalHit = false;
        this.modifiers.clear();
    }
    public int getBackstabCounter() {
        return this.backstabCounter;
    }
    public void setBackstabCounter(int backstabCounterVal) {
        this.backstabCounter = backstabCounterVal;
    }
    public boolean hasCritical() {
        return this.criticalHit;
    }
    public void setCritical(boolean crit) {
        this.criticalHit = crit;
    }
}
