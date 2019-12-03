package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Ignite extends Ability {
    private Pyromancer caster;
    private static final int HUNDRED_AND_FIFTY = 150;
    private static final int THIRTY = 30;
    private static final int TWENTY = 20;
    private static final int FIFTY = 50;
    private static final int THREE = 3;
    public Ignite(final Pyromancer caster) {
        this.caster = caster;
    }
    @Override
    public final void applyOverTimeEffects() {
        if (this.overtimePlayer != null) {
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.overtimePlayer.setHp(this.castee.getHp() - this.damageOverTime);
        }
    }
    @Override
    public final void removeOverTimeEffects() {
        if (this.overtimePlayer != null) {
            this.overtimePlayer.setCurrOverTimeAbility(null);
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(0);
            this.overtimePlayer = null;
        }
    }
    @Override
    public final int use(final Knight knight) {
        this.castee = knight;
        this.baseDamage = HUNDRED_AND_FIFTY + TWENTY * this.caster.getLevel();
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
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(THREE);
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.damageOverTime = FIFTY + THIRTY * this.caster.getLevel();
            for (Float modifier : this.modifiers) {
                this.damageOverTime *= modifier;
            }
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.PYRO_VOLCANIC_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Pyromancer pyromancer) {
        this.castee = pyromancer;
        this.baseDamage = HUNDRED_AND_FIFTY + TWENTY * this.caster.getLevel();
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
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(THREE);
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.damageOverTime = FIFTY + THIRTY * this.caster.getLevel();
            for (Float modifier : this.modifiers) {
                this.damageOverTime *= modifier;
            }
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.PYRO_VOLCANIC_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Rogue rogue) {
        this.castee = rogue;
        this.baseDamage = HUNDRED_AND_FIFTY + TWENTY * this.caster.getLevel();
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
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(THREE);
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.damageOverTime = FIFTY + THIRTY * this.caster.getLevel();
            for (Float modifier : this.modifiers) {
                this.damageOverTime *= modifier;
            }
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.PYRO_VOLCANIC_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Wizard wizard) {
        this.castee = wizard;
        this.baseDamage = HUNDRED_AND_FIFTY + TWENTY * this.caster.getLevel();
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
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(THREE);
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.damageOverTime = FIFTY + THIRTY * this.caster.getLevel();
            for (Float modifier : this.modifiers) {
                this.damageOverTime *= modifier;
            }
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.PYRO_VOLCANIC_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
}
