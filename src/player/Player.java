package player;

import abilities.Ability;
import misc.Cell;
import misc.Map;

import java.util.ArrayList;

public abstract class Player {
    private static final int TWO_HUNDRED_FIFTY = 250;
    private static final int FIFTY = 50;
    protected int id;
    protected int hp;
    protected int maxHp;
    protected int dmg;
    protected int level;
    protected int exp;
    protected int xPos;
    protected int yPos;
    protected String type;
    protected boolean suffersDamageOverTime;
    protected boolean canMove;
    protected int damageOverTime;
    protected String favorableTerrain;
    protected ArrayList<Float> modifiers;
    protected boolean isDead;
    protected Ability currOverTimeAbility;
    protected int overTimeAbilityRemainingRounds;
    protected Cell cellPosition;
    // LEVEL 0, EXP 0, EMPTY MODIFIERS ARRAY, NO DAMAGE OVER TIME
    Player() {
        this.level = 0;
        this.exp = 0;
        this.modifiers = new ArrayList<>();
        this.suffersDamageOverTime = false;
        this.canMove = true;
        this.isDead = false;
    }
    public final void move(final String direction) {
        char dir = direction.charAt(0);
        switch (dir) {
            case 'U':
                this.xPos--;
                break;
            case 'D':
                this.xPos++;
                break;
            case 'L':
                this.yPos--;
                break;
            case 'R':
                this.yPos++;
                break;
            default:
                break;
        }
    }
    public final void checkLevel() {
        if (this.exp >= TWO_HUNDRED_FIFTY + this.level * FIFTY) {
            this.levelUp();
            this.checkLevel();
        } else {
            return;
        }
    }

    public final void update() {
        checkLevel();
        if (this.currOverTimeAbility != null) {
            if (this.getOverTimeAbilityRemainingRounds() == 0) {
                this.currOverTimeAbility.removeOverTimeEffects();
                this.setCurrOverTimeAbility(null);
            }
        }
        this.dmg = 0;
    }

    protected abstract void levelUp();

    @Override
    public final String toString() {
        return this.type + " " + this.xPos + " " + this.yPos;
    }
    public final Cell getCellPosition() {
        return Map.getInstance().getCell(this.xPos, this.yPos);
    }
    public final void setId(final int idVal) {
        this.id = idVal;
    }
    public final int getId() {
        return this.id;
    }
    public final void setHp(final int hpVal) {
        this.hp = hpVal;
    }
    public final int getHp() {
        return this.hp;
    }
    public final int getMaxHp() {
        return this.maxHp;
    }
    public final void setMaxHp(final int maxHpVal) {
        this.maxHp = maxHpVal;
    }
    public final boolean getIsDead() {
        return isDead;
    }
    public final void setDead(final boolean dead) {
        isDead = dead;
    }
    public final void setDmg(final int dmgVal) {
        this.dmg = dmgVal;
    }
    public final int getDmg() {
        return this.dmg;
    }
    public final void setXPos(final int xPosVal) {
        this.xPos = xPosVal;
    }
    public final int getXPos() {
        return this.xPos;
    }
    public final void setYPos(final int yPosVal) {
        this.yPos = yPosVal;
    }
    public final int getYPos() {
        return this.yPos;
    }
    public final int getLevel() {
        return this.level;
    }
    public final void setLevel(final int level) {
        this.level = level;
    }
    public final int getExp() {
        return this.exp;
    }
    public final void setExp(final int exp) {
        this.exp = exp;
    }
    public final String getType() {
        return this.type;
    }
    public final void setType(final String typeVal) {
        this.type = typeVal;
    }
    public final boolean getCanMove() {
        return this.canMove;
    }
    public final void setCanMove(final boolean moveVal) {
        this.canMove = moveVal;
    }
    public final ArrayList<Float> getModifiers() {
        return this.modifiers;
    }
    public final boolean doesSufferDamageOverTime() {
        return this.suffersDamageOverTime;
    }
    public final void setSuffersDamageOverTime(final boolean suffersDamageOverTimeVal) {
        this.suffersDamageOverTime = suffersDamageOverTimeVal;
    }
    public final float getDamageOverTime() {
        return this.damageOverTime;
    }
    public final void setDamageOverTime(final int damageOverTimeVal) {
        this.damageOverTime = damageOverTimeVal;
    }
    public final void setFavorableTerrain(final String terrain) {
        this.favorableTerrain = terrain;
    }
    public final String getFavorableTerrain() {
        return this.favorableTerrain;
    }
    public final void setCurrOverTimeAbility(final Ability ability) {
        this.currOverTimeAbility = ability;
    }
    public final Ability getCurrOverTimeAbility() {
        return this.currOverTimeAbility;
    }
    public final int getOverTimeAbilityRemainingRounds() {
        return this.overTimeAbilityRemainingRounds;
    }
    public final void setOverTimeAbilityRemainingRounds(final int noRounds) {
        this.overTimeAbilityRemainingRounds = noRounds;
    }
    public abstract void isAttackedBy(final Player player);
    public abstract void attacks(final Knight knight);
    public abstract void attacks(final Pyromancer pyromancer);
    public abstract void attacks(final Rogue rogue);
    public abstract void attacks(final Wizard wizard);
}
