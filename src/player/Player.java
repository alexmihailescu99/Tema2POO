package player;

public abstract class Player {
    protected int hp;
    protected int dmg;
    protected int xPos;
    protected int yPos;
    protected String type;

    public abstract void setHp(int hpVal);
    public abstract int getHp();
    public abstract void setDmg(int dmgVal);
    public abstract int getDmg();
    public abstract void setXPos(int xPosVal);
    public abstract int getXPos();
    public abstract void setYPos(int yPosVal);
    public abstract int getYPos();
    public abstract void isAttackedBy(Player player);
    public abstract void attacks(Knight knight);
    public abstract void attacks(Pyromancer pyromancer);
    public abstract void attacks(Rogue rogue);
    public abstract void attacks(Wizard wizard);
}
