package player;

public abstract class Player {
    protected float hp;
    protected float dmg;
    protected int level;
    protected int exp;
    protected int xPos;
    protected int yPos;
    protected String type;

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
    public final float getHp() {
        return this.hp;
    }
    public final void setDmg(int dmgVal) {
        this.dmg = dmgVal;
    }
    public final float getDmg() {
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
    public abstract void isAttackedBy(Player player);
    public abstract void attacks(Knight knight);
    public abstract void attacks(Pyromancer pyromancer);
    public abstract void attacks(Rogue rogue);
    public abstract void attacks(Wizard wizard);
}
