package designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Client in the Flyweight pattern.
 * Plants many trees, but only ever asks {@link TreeFactory} for a
 * {@link TreeType}, never constructing one directly — this is what lets
 * thousands of trees share a handful of flyweight objects.
 */
public class Forest {
    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        trees.add(new Tree(x, y, type));
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int getTreeCount() {
        return trees.size();
    }
}
