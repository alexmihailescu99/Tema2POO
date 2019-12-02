package abilities;

import player.Player;
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
    protected Player castee;
    protected Player overtimePlayer;
    Ability() {
        this.setSnares(false);
        this.setHasDamageOverTime(false);
        this.modifiers = new ArrayList<>();
        this.castee = null;
        this.overtimePlayer = null;
    }
    public abstract int use(Knight knight);
    public abstract int use(Pyromancer pyromancer);
    public abstract int use(Rogue rogue);
    public abstract int use(Wizard wizard);
    public abstract void applyOverTimeEffects();
    public abstract void removeOverTimeEffects();

    protected final void clearAttributes() {
        this.modifiers.clear();
        this.baseDamage = 0;
        this.finalDamage = 0;
    }

    public final Player getOvertimePlayer() {
        return this.overtimePlayer;
    }

    public final void setOvertimePlayer(Player playerRef) {
        this.overtimePlayer = playerRef;
    }

    public final Player getCastee() {
        return this.castee;
    }

    public final void setCastee(Player casteeRef) {
        this.castee = casteeRef;
    }

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
