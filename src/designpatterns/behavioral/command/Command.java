package designpatterns.behavioral.command;

/**
 * Command in the Command pattern (Head First's Remote Control example).
 * Encapsulates a request (and how to undo it) as an object, so the invoker
 * (the remote) can trigger actions on receivers it knows nothing about.
 */
public interface Command {

    void execute();

    /**
     * Reverses whatever {@link #execute()} did, so the invoker can support undo
     * without knowing what the command actually controls.
     */
    void undo();
}
