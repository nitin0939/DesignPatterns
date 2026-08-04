package designpatterns.behavioral.command;

/**
 * Concrete Command in the Command pattern.
 * Binds a {@link Light} receiver to the {@code off()} action.
 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
