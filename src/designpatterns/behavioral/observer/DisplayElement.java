package designpatterns.behavioral.observer;

/**
 * Common interface for anything that can render itself to the console —
 * every concrete {@link Observer} display in this example implements it.
 */
public interface DisplayElement {

    void display();
}
