package abilities;

import misc.Constants;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Drain extends Ability {
    private Wizard caster;
    private static final float POINT_TREE_PERCENT = 0.3f;
    private static final float POINT_TWO_PERCENT = 0.2f;
    private static final float FOUR = 4.0f;
    public Drain(Wizard caster) {
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
        float percent = POINT_TWO_PERCENT + (POINT_TWO_PERCENT / FOUR)
                * this.caster.getLevel();
        float baseDmg = Math.min(POINT_TREE_PERCENT * this.castee.getMaxHp(),
                this.castee.getHp());
        System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            System.out.print(modifier + " ");
            System.out.println();
            percent *= modifier;
        }
        this.finalDamage = Math.round(percent * baseDmg);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName()
                    + " for " + this.finalDamage + " dmg");
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(this.caster + " hit " + this.castee + " with "
                    + this.getClass().getSimpleName() + " for " + this.finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(Pyromancer pyromancer) {
        this.castee = pyromancer;
        float percent = POINT_TWO_PERCENT + (POINT_TWO_PERCENT / FOUR)
                * this.caster.getLevel();
        float baseDmg = Math.min(POINT_TREE_PERCENT * this.castee.getMaxHp(),
                this.castee.getHp());
        for (Float modifier : this.modifiers) {
            percent *= modifier;
        }
        this.finalDamage = Math.round(percent * baseDmg);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
            + " with " + this.getClass().getSimpleName()
            + " for " + this.finalDamage + " dmg");
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(this.caster + " hit " + this.castee + " with "
            + this.getClass().getSimpleName() + " for " + this.finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(Rogue rogue) {
        this.castee = rogue;
        float percent = POINT_TWO_PERCENT + (POINT_TWO_PERCENT / FOUR)
                * this.caster.getLevel();
        float baseDmg = Math.min(POINT_TREE_PERCENT * this.castee.getMaxHp(),
                this.castee.getHp());
        for (Float modifier : this.modifiers) {
            percent *= modifier;
        }
        this.finalDamage = Math.round(percent * baseDmg);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName()
                    + " for " + this.finalDamage + " dmg");
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(this.caster + " hit " + this.castee + " with "
                    + this.getClass().getSimpleName() + " for " + this.finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
    @Override
    public final int use(Wizard wizard) {
        this.castee = wizard;
        float percent = POINT_TWO_PERCENT + (POINT_TWO_PERCENT / FOUR)
                * this.caster.getLevel();
        float baseDmg = Math.min(POINT_TREE_PERCENT * this.castee.getMaxHp(),
                this.castee.getHp());
        for (Float modifier : this.modifiers) {
            percent *= modifier;
        }
        this.finalDamage = Math.round(percent * baseDmg);
        this.castee.setHp(this.castee.getHp() - this.finalDamage);
        if (this.castee.getHp() <= 0) {
            System.out.println(this.caster + " killed " + this.castee
                    + " with " + this.getClass().getSimpleName()
                    + " for " + this.finalDamage + " dmg");
            int gainedExp = Math.max(0, 2 * Constants.HUNDRED - (this.caster.getLevel()
                    - this.castee.getLevel()) * Constants.FORTY);
            this.caster.setExp(this.caster.getExp() + gainedExp);
        } else {
            System.out.println(this.caster + " hit " + this.castee + " with "
                    + this.getClass().getSimpleName() + " for " + this.finalDamage + " dmg");
        }
        int ret = this.finalDamage;
        this.clearAttributes();
        return ret;
    }
}
