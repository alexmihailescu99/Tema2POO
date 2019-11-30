package player;

public final class Rogue extends Player {
    Rogue() {
        System.out.println("Rogue created!");
        this.type = "R";
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
    @Override
    public void setHp(int hpVal) {
        this.hp = hpVal;
    }
    @Override
    public int getHp() {
        return this.hp;
    }
    @Override
    public void setDmg(int dmgVal) {
        this.dmg = dmgVal;
    }
    @Override
    public int getDmg() {
        return this.dmg;
    }
    @Override
    public void setXPos(int xPosVal) {
        this.xPos = xPosVal;
    }
    @Override
    public int getXPos() {
        return this.xPos;
    }
    @Override
    public void setYPos(int yPosVal) {
        this.yPos = yPosVal;
    }
    @Override
    public int getYPos() {
        return this.yPos;
    }
    @Override
    public String toString() {
        return this.type + " " + this.xPos + " " + this.yPos;
    }
}
