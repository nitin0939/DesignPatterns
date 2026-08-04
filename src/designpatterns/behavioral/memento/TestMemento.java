package designpatterns.behavioral.memento;

/**
 * Client class that demonstrates the Memento pattern.
 * Checkpoints a text editor's content at two points, keeps typing, then
 * undoes twice by restoring earlier snapshots from {@link History}.
 */
public class TestMemento {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello");
        history.push(editor.save());

        editor.write(", world");
        history.push(editor.save());

        editor.write("!!!");
        System.out.println("Current content: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("After 1 undo:     " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("After 2nd undo:   " + editor.getContent());
    }
}
