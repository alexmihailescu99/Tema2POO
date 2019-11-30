package player;

public final class Knight extends Player {
    @Override
    public void isAttackedBy(Player player) {
        player.attacks(this);
    }
}
