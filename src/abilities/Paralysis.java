package abilities;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Paralysis extends Ability {
    private Rogue caster;
    public Paralysis(Rogue caster) {
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
    public int use(Knight knight) {
        return 0;
    }
    @Override
    public int use(Pyromancer pyromancer) {
        return 0;
    }
    @Override
    public int use(Rogue rogue) {
        return 0;
    }
    @Override
    public int use(Wizard wizard) {
        return 0;
    }
}
