package abilities;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Fireblast extends Ability {
    private Pyromancer caster;
    public Fireblast(Pyromancer caster) {
        this.caster = caster;
    }
    @Override
    public void applyOverTimeEffects() {
        //
    }
    @Override
    public void removeOverTimeEffects() {
        //
    }
    @Override
    public final int use(Knight knight) {
        return 0;
    }
    @Override
    public final int use(Pyromancer pyromancer) {
        return 0;
    }
    @Override
    public final int use(Rogue rogue) {
        return 0;
    }
    @Override
    public final int use(Wizard wizard) {
        return 0;
    }
}
