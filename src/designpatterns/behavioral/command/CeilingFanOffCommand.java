package designpatterns.behavioral.command;

/**
 * Concrete Command in the Command pattern.
 * Binds a {@link CeilingFan} receiver to its {@code off()} action, capturing
 * the prior speed so {@link #undo()} can restore it.
 */
public class CeilingFanOffCommand implements Command {
    private final CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

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
