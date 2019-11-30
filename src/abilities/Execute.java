package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Execute extends Ability {
    private Knight caster;
    public Execute(Knight caster) {
        super();
        this.caster = caster;
        this.baseDamage = Constants.KNIGHT_EXECUTE_BASE_DAMAGE
                + caster.getLevel() * Constants.KNIGHT_EXECUTE_DAMAGE_PER_LEVEL;
    }
    @Override
    public final void use(Knight knight) {
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
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
