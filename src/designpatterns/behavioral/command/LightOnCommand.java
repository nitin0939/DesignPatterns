package designpatterns.behavioral.command;

/**
 * Concrete Command in the Command pattern.
 * Binds a {@link Light} receiver to the {@code on()} action.
 */
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
