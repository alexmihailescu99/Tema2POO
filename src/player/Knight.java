package player;
import abilities.Execute;
import abilities.Slam;
import misc.Cell;
import misc.Constants;
import misc.Map;

public final class Knight extends Player {
    private Execute execute;
    private Slam slam;
    private static final int LEVEL_HP_MODIFIER = 80;
    private static final float WIZZ_EXECUTE_DMG_MODIFIER = 0.8f;
    private static final float WIZZ_SLAM_DMG_MODIFIER = 1.05f;
    private static final float PYRO_EXECUTE_DMG_MODIFIER = 1.1f;
    private static final float PYRO_SLAM_DMG_MODIFIER = 0.9f;
    private static final float ROGUE_EXECUTE_DMG_MODIFIER = 1.15f;
    private static final float ROGUE_SLAM_DMG_MODIFIER = 0.8f;
    Knight() {
        super();
        this.setType("K");
        this.setFavorableTerrain("L");
        this.setHp(Constants.KNIGHT_HP);
        this.setMaxHp(Constants.KNIGHT_HP);
        this.execute = new Execute(this);
        this.slam = new Slam(this);
    }
    @Override
    public void levelUp() {
        this.level++;
        System.out.println(this + " has advanced to level " + this.level);
        this.maxHp = Constants.KNIGHT_HP + this.getLevel() * LEVEL_HP_MODIFIER;
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
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.use(knight);
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.slam.addModifier(Constants.KNIGHT_ON_KNIGHT_SLAM_MODIFIER);
        this.slam.use(knight);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Pyromancer pyromancer) {
        System.out.println(this + " attacks " + pyromancer);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.addModifier(PYRO_EXECUTE_DMG_MODIFIER);
        this.execute.use(pyromancer);
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.slam.addModifier(PYRO_SLAM_DMG_MODIFIER);
        this.slam.use(pyromancer);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Rogue rogue) {
        System.out.println(this + " attacks " + rogue);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.addModifier(ROGUE_EXECUTE_DMG_MODIFIER);
        this.execute.use(rogue);
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.slam.addModifier(ROGUE_SLAM_DMG_MODIFIER);
        this.slam.use(rogue);
        this.modifiers.clear();
    }
    @Override
    public void attacks(Wizard wizard) {
        System.out.println(this + " attacks " + wizard);
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.addModifier(WIZZ_EXECUTE_DMG_MODIFIER);
        int dmg1 = this.execute.use(wizard);
        int prevExp = this.getExp();
        boolean wasAlreadyDead = false;
        if (wizard.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.slam.addModifier(WIZZ_SLAM_DMG_MODIFIER);
        int dmg2 = this.slam.use(wizard);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.dmg = dmg1 + dmg2;
        System.out.println("I AM ADDING " + dmg1 + " and " + dmg2);
        this.modifiers.clear();
    }
}
