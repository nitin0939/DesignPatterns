package designpatterns.behavioral.command;

/**
 * Concrete Command in the Command pattern.
 * Binds a {@link CeilingFan} receiver to its {@code high()} action, and
 * captures the fan's prior speed so {@link #undo()} can restore it exactly —
 * unlike a light switch, "undo" here isn't just the opposite action.
 */
public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    /**
     * Restores whatever speed the fan was at before this command ran, instead
     * of always turning it off.
     */
    @Override
    public void undo() {
        if (previousSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (previousSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else {
            ceilingFan.off();
        }
    }
}
