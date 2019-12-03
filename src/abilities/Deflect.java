package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Deflect extends Ability {
    private Wizard caster;
    private static final float POINT_TREE_PERCENT = 0.3f;
    private static final float POINT_TWO_PERCENT = 0.2f;
    private static final float FOUR = 4.0f;
    private static final float INITIAL_PERCENT = 0.35f;
    private static final float TEN = 10.0f;
    private static final float PERCENT_LIMIT = 0.7f;
    public Deflect(final Wizard caster) {
        this.caster = caster;
    }
    @Override
    public final void applyOverTimeEffects() {
        return;
    }
    @Override
    public final void removeOverTimeEffects() {
        return;
    }
    @Override
    public final int use(final Knight knight) {
        this.castee = knight;
        float percent = INITIAL_PERCENT + (POINT_TWO_PERCENT / TEN)
                * this.caster.getLevel();
        int damageDealtByEnemy = this.castee.getDmg();
        for (Float modifier : this.modifiers) {
            percent *= modifier;
        }
        if (percent > PERCENT_LIMIT) {
            percent = PERCENT_LIMIT;
        }
        this.finalDamage = Math.round(percent * this.castee.getDmg());
        this.castee.setHp(this.castee.getHp() - finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        this.clearAttributes();
        return this.finalDamage;
    }
    @Override
    public final int use(final Pyromancer pyromancer) {
        this.castee = pyromancer;
        float percent = INITIAL_PERCENT + (POINT_TWO_PERCENT / TEN)
                * this.caster.getLevel();
        int damageDealtByEnemy = this.castee.getDmg();
        for (Float modifier : this.modifiers) {
            percent *= modifier;
        }
        if (percent > PERCENT_LIMIT) {
            percent = PERCENT_LIMIT;
        }
        this.finalDamage = Math.round(percent * this.castee.getDmg());
        this.castee.setHp(this.castee.getHp() - finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        this.clearAttributes();
        return this.finalDamage;
    }
    @Override
    public final int use(final Rogue rogue) {
        this.castee = rogue;
        float percent = INITIAL_PERCENT + (POINT_TWO_PERCENT / TEN)
                * this.caster.getLevel();
        int damageDealtByEnemy = this.castee.getDmg();
        for (Float modifier : this.modifiers) {
            percent *= modifier;
        }
        if (percent > PERCENT_LIMIT) {
            percent = PERCENT_LIMIT;
        }
        this.finalDamage = Math.round(percent * this.castee.getDmg());
        this.castee.setHp(this.castee.getHp() - finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        this.clearAttributes();
        return this.finalDamage;
    }
    @Override
    public final int use(final Wizard wizard) {
        return 0;
    }
}
