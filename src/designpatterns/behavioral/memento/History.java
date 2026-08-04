package designpatterns.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Caretaker in the Memento pattern.
 * Stores {@link TextEditor.Memento} snapshots and hands them back on
 * request, but never looks inside one — it only ever holds them as opaque
 * objects, since their internals are {@code private} to {@link TextEditor}.
 */
public class History {
    private final Deque<TextEditor.Memento> checkpoints = new ArrayDeque<>();

    public void push(TextEditor.Memento memento) {
        checkpoints.push(memento);
    }

    public TextEditor.Memento pop() {
        return checkpoints.pop();
    }

    public boolean isEmpty() {
        return checkpoints.isEmpty();
    }
}
