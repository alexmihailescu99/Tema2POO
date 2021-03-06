package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Slam extends Ability {
    private Knight caster;
    private static final int KNIGHT_SLAM_BASE_DAMAGE = 100;
    private static final int KNIGHT_SLAM_DAMAGE_PER_LEVEL = 40;
    public Slam(final Knight caster) {
        super();
        this.caster = caster;
        this.setSnares(true);
        this.baseDamage = KNIGHT_SLAM_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_SLAM_DAMAGE_PER_LEVEL;
    }
    @Override
    public final void applyOverTimeEffects() {
        if (this.overtimePlayer != null) {
            this.overtimePlayer.setCurrOverTimeAbility(this);
            this.overtimePlayer.setCanMove(false);
        }
    }
    @Override
    public final void removeOverTimeEffects() {
        if (this.overtimePlayer != null) {
            this.overtimePlayer.setCurrOverTimeAbility(null);
            this.overtimePlayer.setCanMove(true);
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(0);
        }
    }
    @Override
    public final int use(final Knight knight) {
        this.castee = knight;
        this.baseDamage = Constants.HUNDRED + Constants.FORTY * this.caster.getLevel();
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
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(2);
            this.applyOverTimeEffects();
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.KNIGHT_LAND_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Pyromancer pyromancer) {
        this.castee = pyromancer;
        this.baseDamage = Constants.HUNDRED + Constants.FORTY * this.caster.getLevel();
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
            this.overtimePlayer = this.castee;
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(2);
            this.applyOverTimeEffects();
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.KNIGHT_LAND_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Rogue rogue) {
        this.castee = rogue;
        this.baseDamage = Constants.HUNDRED + Constants.FORTY * this.caster.getLevel();
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
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(2);
            this.applyOverTimeEffects();
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.KNIGHT_LAND_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(final Wizard wizard) {
        this.castee = wizard;
        this.baseDamage = Constants.HUNDRED + Constants.FORTY * this.caster.getLevel();
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
            this.overtimePlayer.setOverTimeAbilityRemainingRounds(2);
            this.applyOverTimeEffects();
        }
        int ret;
        if (this.caster.getCellPosition().getType().equals(
                this.caster.getFavorableTerrain())) {
            ret = Math.round(this.baseDamage * Constants.KNIGHT_LAND_MODIFIER);
        } else {
            ret = this.baseDamage;
        }
        this.clearAttributes();
        return ret;
    }
}
