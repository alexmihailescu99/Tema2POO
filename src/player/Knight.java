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
        this.maxHp = Constants.KNIGHT_HP + this.getLevel() * LEVEL_HP_MODIFIER;
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
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.use(knight);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
        if (knight.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }

        this.slam.addModifier(Constants.KNIGHT_ON_KNIGHT_SLAM_MODIFIER);
        this.slam.use(knight);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.modifiers.clear();
    }
    @Override
    public void attacks(final Pyromancer pyromancer) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.addModifier(PYRO_EXECUTE_DMG_MODIFIER);
        this.execute.use(pyromancer);
        boolean wasAlreadyDead = false;
        if (pyromancer.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }

        this.slam.addModifier(PYRO_SLAM_DMG_MODIFIER);
        this.slam.use(pyromancer);
        int prevExp = this.getExp();
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.modifiers.clear();
    }
    @Override
    public void attacks(final Rogue rogue) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.addModifier(ROGUE_EXECUTE_DMG_MODIFIER);
        this.execute.use(rogue);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
        if (rogue.getHp() <= 0) {
            wasAlreadyDead = true;
        }
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.slam.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }

        this.slam.addModifier(ROGUE_SLAM_DMG_MODIFIER);
        this.slam.use(rogue);
        if (wasAlreadyDead) {
            this.setExp(prevExp);
        }
        this.modifiers.clear();
    }
    @Override
    public void attacks(final Wizard wizard) {
        Cell playerCell = Map.getInstance().getCell(this.getXPos(), this.getYPos());
        if (playerCell.getType().equals(this.getFavorableTerrain())) {
            this.execute.addModifier(Constants.KNIGHT_LAND_MODIFIER);
        }
        this.execute.addModifier(WIZZ_EXECUTE_DMG_MODIFIER);
        int dmg1 = this.execute.use(wizard);
        boolean wasAlreadyDead = false;
        int prevExp = this.getExp();
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
        this.modifiers.clear();
    }
}
