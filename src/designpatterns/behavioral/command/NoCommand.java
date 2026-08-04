package designpatterns.behavioral.command;

/**
 * Null Object companion to the Command pattern.
 * Fills every remote control slot that hasn't been assigned a real command,
 * so the invoker never needs a null check before calling {@code execute()}.
 */
public class NoCommand implements Command {

    @Override
    public void execute() {
        // Intentionally does nothing — this slot has no command assigned.
    }

    @Override
    public void undo() {
        // Intentionally does nothing.
    }
}
