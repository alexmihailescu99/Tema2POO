package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Slam extends Ability {
    private Knight caster;
    public Slam(Knight caster) {
        super();
        this.caster = caster;
        this.setSnares(true);
        this.baseDamage = Constants.KNIGHT_SLAM_BASE_DAMAGE
                + caster.getLevel() * Constants.KNIGHT_SLAM_DAMAGE_PER_LEVEL;
    }
    @Override
    public final void use(Knight knight) {
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        knight.setHp(knight.getHp() - this.finalDamage);
        knight.setCanMove(false);
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
