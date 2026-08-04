package designpatterns.behavioral.command;

/**
 * Invoker in the Command pattern.
 * Holds an "on" and "off" {@link Command} per slot and simply calls
 * {@code execute()}/{@code undo()} on whichever command occupies that slot —
 * it never references {@link Light}, {@link CeilingFan}, or any other
 * receiver directly.
 */
public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command lastCommand;

    public RemoteControl(int slotCount) {
        onCommands = new Command[slotCount];
        offCommands = new Command[slotCount];

        Command noCommand = new NoCommand();
        for (int i = 0; i < slotCount; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        lastCommand = noCommand;
    }

    /**
     * Assigns an on/off command pair to a numbered slot on the remote.
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
        lastCommand = onCommands[slot];
    }

    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
        lastCommand = offCommands[slot];
    }

    /**
     * Undoes whichever command was executed most recently, regardless of
     * which slot or receiver it came from.
     */
    public void undoButtonPushed() {
        lastCommand.undo();
    }
}
