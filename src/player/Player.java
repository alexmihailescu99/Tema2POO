package player;

import java.util.ArrayList;

public abstract class Player {
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
    // LEVEL 0, EXP 0, EMPTY MODIFIERS ARRAY, NO DAMAGE OVER TIME
    Player() {
        this.level = 0;
        this.exp = 0;
        this.modifiers = new ArrayList<>();
        this.suffersDamageOverTime = false;
        this.canMove = true;
        this.isDead = false;
    }
    public final void move(String direction) {
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
            default: System.out.println("Illegal move!");
        }
    }
    @Override
    public final String toString() {
        return this.type + " " + this.xPos + " " + this.yPos;
    }

    public final void setHp(int hpVal) {
        this.hp = hpVal;
    }
    public final int getHp() {
        return this.hp;
    }
    public final int getMaxHp() {
        return this.maxHp;
    }
    public final void setMaxHp(int maxHpVal) {
        this.maxHp = maxHpVal;
    }
    public final boolean getIsDead() {
        return isDead;
    }
    public final void setDead(boolean dead) {
        isDead = dead;
    }
    public final void setDmg(int dmgVal) {
        this.dmg = dmgVal;
    }
    public final int getDmg() {
        return this.dmg;
    }
    public final void setXPos(int xPosVal) {
        this.xPos = xPosVal;
    }
    public final int getXPos() {
        return this.xPos;
    }
    public final void setYPos(int yPosVal) {
        this.yPos = yPosVal;
    }
    public final int getYPos() {
        return this.yPos;
    }
    public final int getLevel() {
        return this.level;
    }
    public final void setLevel(int level) {
        this.level = level;
    }
    public final int getExp() {
        return this.exp;
    }
    public final void setExp(int exp) {
        this.exp = exp;
    }
    public final String getType() {
        return this.type;
    }
    public final void setType(String typeVal) {
        this.type = typeVal;
    }
    public final boolean getCanMove() {
        return this.canMove;
    }
    public final void setCanMove(boolean moveVal) {
        this.canMove = moveVal;
    }
    public final ArrayList<Float> getModifiers() {
        return this.modifiers;
    }
    public final void addModifier(float modifier) {
        this.modifiers.add(modifier);
    }
    public final boolean doesSufferDamageOverTime() {
        return this.suffersDamageOverTime;
    }
    public final void setSuffersDamageOverTime(boolean suffersDamageOverTimeVal) {
        this.suffersDamageOverTime = suffersDamageOverTimeVal;
    }
    public final float getDamageOverTime() {
        return this.damageOverTime;
    }
    public final void setDamageOverTime(int damageOverTimeVal) {
        this.damageOverTime = damageOverTimeVal;
    }
    public final void setFavorableTerrain(String terrain) {
        this.favorableTerrain = terrain;
    }
    public final String getFavorableTerrain() {
        return this.favorableTerrain;
    }
    public abstract void isAttackedBy(Player player);
    public abstract void attacks(Knight knight);
    public abstract void attacks(Pyromancer pyromancer);
    public abstract void attacks(Rogue rogue);
    public abstract void attacks(Wizard wizard);
    public abstract void update();
}
