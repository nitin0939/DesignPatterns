package designpatterns.structural.flyweight;

/**
 * Flyweight in the Flyweight pattern.
 * (Head First Design Patterns only covers Flyweight briefly, in its
 * "leftover patterns" chapter, without a fully worked example — this is a
 * book-style example built for this repo, not a verbatim one.)
 * Holds the state that's identical across every tree of one species/color/
 * texture combination — the "intrinsic" state, shared by every tree that
 * looks the same, instead of being duplicated per tree instance.
 */
public class TreeType {
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    /**
     * Renders one tree of this type at the given position. The position
     * (extrinsic state) is passed in per call, never stored on the flyweight
     * itself — that's what lets one {@code TreeType} instance be reused for
     * thousands of trees at different coordinates.
     */
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " " + name + " (" + texture + " texture) at (" + x + ", " + y + ")");
    }
}
