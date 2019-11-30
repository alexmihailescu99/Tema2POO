package abilities;

import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

import java.util.ArrayList;

public abstract class Ability {
    protected int baseDamage;
    protected boolean snares;
    protected boolean hasDamageOverTime;
    protected int damageOverTime;
    protected int finalDamage;
    protected ArrayList<Float> modifiers;
    Ability() {
        this.setSnares(false);
        this.setHasDamageOverTime(false);
        this.modifiers = new ArrayList<>();
    }
    public abstract void use(Knight knight);
    public abstract void use(Pyromancer pyromancer);
    public abstract void use(Rogue rogue);
    public abstract void use(Wizard wizard);
    public final int getBaseDamage() {
        return this.baseDamage;
    }

    public final void setBaseDamage(int baseDamageVal) {
        this.baseDamage = baseDamageVal;
    }

    public final boolean doesSnare() {
        return this.snares;
    }

    public final void setSnares(boolean snares) {
        this.snares = snares;
    }

    public final ArrayList<Float> getModifiers() {
        return this.modifiers;
    }

    public final void addModifier(float modifier) {
        this.modifiers.add(modifier);
    }

    public final int getFinalDamage() {
        return this.finalDamage;
    }

    public final void setFinalDamage(int finalDamageVal) {
        this.finalDamage = finalDamageVal;
    }

    public final boolean doesDamageOverTime() {
        return this.hasDamageOverTime;
    }

    public final void setHasDamageOverTime(boolean val) {
        this.hasDamageOverTime = val;
    }

    public final int getDamageOverTime() {
        return this.damageOverTime;
    }

    public final void setDamageOverTime(int damageVal) {
        this.damageOverTime = damageVal;
    }
}
