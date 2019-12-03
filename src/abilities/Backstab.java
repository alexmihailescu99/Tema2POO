package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Backstab extends Ability {
    private Rogue caster;
    private static final float ROGUE_CRIT_MODIFIER = 1.5f;
    public Backstab(final Rogue caster) {
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
        this.baseDamage = 2 * Constants.HUNDRED + (Constants.FORTY  / 2) * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.ROGUE_WOODS_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Pyromancer pyromancer) {
        this.castee = pyromancer;
        this.baseDamage = 2 * Constants.HUNDRED + (Constants.FORTY  / 2) * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.ROGUE_WOODS_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Rogue rogue) {
        this.castee = rogue;
        this.baseDamage = 2 * Constants.HUNDRED + (Constants.FORTY  / 2) * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        int ret;
        if (this.caster.hasCritical()) {
            if (this.caster.getCellPosition().getType().equals(
                    this.caster.getFavorableTerrain())) {
                ret = Math.round(this.baseDamage * Constants.ROGUE_WOODS_MODIFIER
                        * ROGUE_CRIT_MODIFIER);
            } else {
                ret = Math.round(this.baseDamage * ROGUE_CRIT_MODIFIER);
            }
        }
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.ROGUE_WOODS_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Wizard wizard) {
        this.castee = wizard;
        this.baseDamage = 2 * Constants.HUNDRED + (Constants.FORTY  / 2) * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        }
        int ret;
        if (this.caster.hasCritical()) {
            if (this.caster.getCellPosition().getType().equals(
                    this.caster.getFavorableTerrain())) {
                ret = Math.round(this.baseDamage * Constants.ROGUE_WOODS_MODIFIER
                        * ROGUE_CRIT_MODIFIER);
                return ret;
            } else {
                ret = Math.round(this.baseDamage * ROGUE_CRIT_MODIFIER);
                return ret;
            }
        }
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.ROGUE_WOODS_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
}
