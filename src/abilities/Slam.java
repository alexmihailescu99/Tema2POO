package abilities;


import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Slam extends Ability {
    private Knight caster;
    private static final int KNIGHT_SLAM_BASE_DAMAGE = 100;
    private static final int KNIGHT_SLAM_DAMAGE_PER_LEVEL = 40;
    public Slam(Knight caster) {
        super();
        this.caster = caster;
        this.setSnares(true);
        this.baseDamage = KNIGHT_SLAM_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_SLAM_DAMAGE_PER_LEVEL;
    }
    @Override
    public final void use(Knight knight) {
        float totalDamage = this.baseDamage;
        System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            System.out.print(modifier + " ");
            System.out.println();
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        knight.setHp(knight.getHp() - this.finalDamage);
        knight.setCanMove(false);
        System.out.println(caster + " slammed " + knight + " for " + finalDamage + " dmg");
        this.modifiers.clear();
    }
    @Override
    public void use(Pyromancer pyromancer) {
        //
    }
    @Override
    public void use(Rogue rogue) {
        //
    }
    @Override
    public void use(Wizard wizard) {
        //
    }
}
