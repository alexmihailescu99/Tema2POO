package abilities;

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
    private void clearAttributes() {
        this.baseDamage = 0;
        this.finalDamage = 0;
        this.modifiers.clear();
    }
    @Override
    public final void use(Knight knight) {
        float hpLimit;
        if (knight.getLevel() > EXECUTE_ENEMY_LEVEL_LIMIT) {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP  + EXECUTE_ENEMY_LIMIT_MODIFIER)
                    * knight.getMaxHp();
        } else {
            hpLimit = (EXECUTE_PERCENT_OF_ENEMY_HP + EXECUTE_ENEMY_HP_MODIFIER
                    * knight.getLevel()) * knight.getMaxHp();
        }
        if (knight.getHp() < hpLimit) {
            this.finalDamage = Math.round(hpLimit);
            knight.setHp(knight.getHp() - this.finalDamage);
            System.out.println(caster + " executed " + knight + " for "
                    + this.finalDamage + " dmg");
            return;
        }
        this.baseDamage = KNIGHT_EXECUTE_BASE_DAMAGE
                + caster.getLevel() * KNIGHT_EXECUTE_DAMAGE_PER_LEVEL;
        float totalDamage = this.baseDamage;
        System.out.println(this.getClass().getSimpleName());
        for (Float modifier : this.modifiers) {
            System.out.print(modifier + " ");
            System.out.println();
            totalDamage *= modifier;
        }
        this.finalDamage = Math.round(totalDamage);
        System.out.println(caster + " hit " + knight + " with execute for " + finalDamage + " dmg");
        knight.setHp(knight.getHp() - this.finalDamage);
        this.clearAttributes();
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
