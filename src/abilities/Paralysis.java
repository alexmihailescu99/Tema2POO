package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Paralysis extends Ability {
    private Rogue caster;
    private static final int OVERTIME_ROUNDS_WOODS = 7;
    private static final int OVERTIME_ROUNDS_NORMAL = 4;
    public Paralysis(final Rogue caster) {
        this.caster = caster;
    }

    @Override
    public final void applyOverTimeEffects() {
        if (this.overtimePlayer != null) {
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.overtimePlayer.setCanMove(false);
            this.overtimePlayer.setHp(this.castee.getHp() - this.damageOverTime);
        }
    }

    @Override
    public final void removeOverTimeEffects() {
        if (this.overtimePlayer != null) {
            this.overtimePlayer.setCurrOverTimeAbility(null);
            this.overtimePlayer.setCanMove(true);
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(0);
            this.overtimePlayer = null;
        }
    }

    @Override
    public final int use(final Knight knight) {
        this.castee = knight;
        this.baseDamage = Constants.FORTY + Constants.TEN * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        //this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            if (this.caster.getCellPosition().getType().equals(
                    this.caster.getFavorableTerrain())) {
                this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_WOODS);
            }
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_NORMAL);
            this.damageOverTime = this.finalDamage;
            this.applyOverTimeEffects();
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
        this.baseDamage = Constants.FORTY + Constants.TEN * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        //this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            if (this.caster.getCellPosition().getType().equals(
                    this.caster.getFavorableTerrain())) {
                this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_WOODS);
            }
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_NORMAL);
            this.damageOverTime = this.finalDamage;
            this.applyOverTimeEffects();
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
        this.baseDamage = Constants.FORTY + Constants.TEN * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        //this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            if (this.caster.getCellPosition().getType().equals(
                    this.caster.getFavorableTerrain())) {
                this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_WOODS);
            }
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_NORMAL);
            this.damageOverTime = this.finalDamage;
            this.applyOverTimeEffects();
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
    public final int use(final Wizard wizard) {
        this.castee = wizard;
        this.baseDamage = Constants.FORTY + Constants.TEN * this.caster.getLevel();
        float totalDamage = this.baseDamage;
        for (Float modifier : this.modifiers) {
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        //this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            int gainedExp = Math.max(0, Constants.HUNDRED * 2 - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            // Set the player to which this instance of ability applies overtime effects
            this.overtimePlayer = this.castee;
            if (this.caster.getCellPosition().getType().equals(
                    this.caster.getFavorableTerrain())) {
                this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_WOODS);
            }
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(OVERTIME_ROUNDS_NORMAL);
            this.damageOverTime = this.finalDamage;
            this.applyOverTimeEffects();
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
}
