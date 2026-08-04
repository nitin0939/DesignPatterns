package designpatterns.behavioral.memento;

/**
 * Originator in the Memento pattern.
 * (Head First Design Patterns only covers Memento briefly, in its "leftover
 * patterns" chapter, without a fully worked example — this is a book-style
 * example built for this repo, not a verbatim one.)
 * Can capture its own state into a {@link Memento} snapshot, and later
 * restore from one — but the snapshot's internals are only ever reachable
 * through this class, never by whoever is holding it.
 */
public class TextEditor {
    private String content = "";

    public void write(String text) {
        content += text;
    }

    public String getContent() {
        return content;
    }

    /**
     * Captures the current content into an opaque snapshot.
     */
    public Memento save() {
        return new Memento(content);
    }

    /**
     * Restores this editor's content from a previously captured snapshot.
     */
    public void restore(Memento memento) {
        this.content = memento.getSavedContent();
    }

    /**
     * Memento in the Memento pattern.
     * A {@code private} nested class with a {@code private} constructor and
     * getter — {@link History} (the caretaker) can hold and pass these
     * around, but only {@link TextEditor} itself (its enclosing class) can
     * ever construct one or read what's inside it.
     */
    public static class Memento {
        private final String content;

        private Memento(String content) {
            this.content = content;
        }

        private String getSavedContent() {
            return content;
        }
    }
}
