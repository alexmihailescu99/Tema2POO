package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Execute extends Ability {
    private Knight caster;
    private static final int KNIGHT_EXECUTE_BASE_DAMAGE = 200;
    private static final int KNIGHT_EXECUTE_DAMAGE_PER_LEVEL = 30;
    private static final float EXECUTE_PERCENT_OF_ENEMY_HP = 0.2f;
    private static final float EXECUTE_ENEMY_HP_MODIFIER = 0.01f;
    private static final int EXECUTE_ENEMY_LEVEL_LIMIT = 40;
    private static final float EXECUTE_ENEMY_LIMIT_MODIFIER = 0.4f;

    public Execute(Knight caster) {
        super();
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
    public final int use(Knight knight) {
        this.castee = knight;
        float hpLimit;
        if (this.castee.getLevel() > EXECUTE_ENEMY_LEVEL_LIMIT) {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP  + EXECUTE_ENEMY_LIMIT_MODIFIER)
                    * this.castee.getMaxHp();
        } else {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP + EXECUTE_ENEMY_HP_MODIFIER
                    * this.castee.getLevel()) * this.castee.getMaxHp();
        }
        if (this.castee.getHp() < hpLimit) {
            this.finalDamage = Math.round(hpLimit);
            this.castee.setHp(this.castee.getHp() - this.finalDamage);
            System.out.println(caster + " executed " + this.castee + " for "
                    + this.finalDamage + " dmg");
            return this.finalDamage;
        }
        this.baseDamage = KNIGHT_EXECUTE_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_EXECUTE_DAMAGE_PER_LEVEL;
        float totalDamage = this.baseDamage;
        //System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            //System.out.print(modifier + " ");
            //System.out.println();
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName());
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(caster + " hit " + this.castee + " with execute for " + finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(Pyromancer pyromancer) {
        this.castee = pyromancer;
        float hpLimit;
        if (this.castee.getLevel() > EXECUTE_ENEMY_LEVEL_LIMIT) {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP  + EXECUTE_ENEMY_LIMIT_MODIFIER)
                    * this.castee.getMaxHp();
        } else {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP + EXECUTE_ENEMY_HP_MODIFIER
                    * this.castee.getLevel()) * this.castee.getMaxHp();
        }
        if (this.castee.getHp() < hpLimit) {
            this.finalDamage = Math.round(hpLimit);
            this.castee.setHp(this.castee.getHp() - this.finalDamage);
            System.out.println(caster + " executed " + this.castee + " for "
                    + this.finalDamage + " dmg");
            return this.finalDamage;
        }
        this.baseDamage = KNIGHT_EXECUTE_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_EXECUTE_DAMAGE_PER_LEVEL;
        float totalDamage = this.baseDamage;
        //System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            //System.out.print(modifier + " ");
            //System.out.println();
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName());
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            System.out.println(gainedExp);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(caster + " hit " + this.castee + " with execute for " + finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(Rogue rogue) {
        this.castee = rogue;
        float hpLimit;
        if (this.castee.getLevel() > EXECUTE_ENEMY_LEVEL_LIMIT) {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP  + EXECUTE_ENEMY_LIMIT_MODIFIER)
                    * this.castee.getMaxHp();
        } else {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP + EXECUTE_ENEMY_HP_MODIFIER
                    * this.castee.getLevel()) * this.castee.getMaxHp();
        }
        if (this.castee.getHp() < hpLimit) {
            this.finalDamage = Math.round(hpLimit);
            this.castee.setHp(this.castee.getHp() - this.finalDamage);
            System.out.println(caster + " executed " + this.castee + " for "
                    + this.finalDamage + " dmg");
            return this.finalDamage;
        }
        this.baseDamage = KNIGHT_EXECUTE_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_EXECUTE_DAMAGE_PER_LEVEL;
        float totalDamage = this.baseDamage;
        //System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            //System.out.print(modifier + " ");
            //System.out.println();
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName());
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            System.out.println(gainedExp);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(caster + " hit " + this.castee + " with execute for " + finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(Wizard wizard) {
        this.castee = wizard;
        float hpLimit;
        if (this.castee.getLevel() > EXECUTE_ENEMY_LEVEL_LIMIT) {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP  + EXECUTE_ENEMY_LIMIT_MODIFIER)
                    * this.castee.getMaxHp();
        } else {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP + EXECUTE_ENEMY_HP_MODIFIER
                    * this.castee.getLevel()) * this.castee.getMaxHp();
        }
        if (this.castee.getHp() < hpLimit) {
            this.finalDamage = Math.round(hpLimit);
            this.castee.setHp(this.castee.getHp() - this.finalDamage);
            System.out.println(caster + " executed " + this.castee + " for "
                    + this.finalDamage + " dmg");
            return this.finalDamage;
        }
        this.baseDamage = KNIGHT_EXECUTE_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_EXECUTE_DAMAGE_PER_LEVEL;
        float totalDamage = this.baseDamage;
        //System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            //System.out.print(modifier + " ");
            //System.out.println();
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName()
                    + " for " + this.finalDamage + " dmg");
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            System.out.println(gainedExp);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(caster + " hit " + this.castee + " with execute for " + finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
}
