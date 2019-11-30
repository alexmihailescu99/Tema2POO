package player;
import abilities.Execute;
import abilities.Slam;
import misc.Cell;
import misc.Constants;
import misc.Map;

public final class Knight extends Player {
    private Execute execute;
    private Slam slam;
    Knight() {
        super();
        this.setType("K");
        this.setFavorableTerrain("L");
        this.setHp(Constants.KNIGHT_HP);
        this.execute = new Execute(this);
        this.slam = new Slam(this);
    }
    @Override
    public void isAttackedBy(Player player) {
        player.attacks(this);
    }
    @Override
    public void attacks(Knight knight) {
        System.out.println(this + " attacks " + knight);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType() == this.getFavorableTerrain()) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.use(knight);
        if (playerCell.getType() == this.getFavorableTerrain()) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.slam.addModifier(Constants.KNIGHT_ON_KNIGHT_SLAM_MODIFIER);
        this.slam.use(knight);
        this.modifiers.clear();
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
