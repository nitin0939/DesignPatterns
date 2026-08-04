package designpatterns.structural.flyweight;

/**
 * Context object in the Flyweight pattern.
 * Holds only the state that's genuinely unique per tree — its position (the
 * "extrinsic" state) — plus a reference to the shared {@link TreeType}
 * flyweight for everything else. A forest can hold thousands of these
 * cheaply, since only the position is duplicated per instance.
 */
public class Tree {
    private final int x;
    private final int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * Passes this tree's unique position into the shared flyweight's draw method.
     */
    public void draw() {
        type.draw(x, y);
    }
}
