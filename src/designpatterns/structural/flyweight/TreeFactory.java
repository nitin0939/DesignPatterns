package designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory in the Flyweight pattern.
 * Ensures flyweights are shared: a {@link TreeType} for a given
 * name/color/texture combination is created once and handed out to every
 * caller that asks for that same combination again.
 */
public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    /**
     * Returns the shared {@link TreeType} for this combination, creating it
     * only the first time it's requested.
     */
    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        TreeType result = treeTypes.get(key);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(key, result);
            System.out.println("Created a new TreeType flyweight for: " + key);
        }
        return result;
    }

    public static int getCreatedTypeCount() {
        return treeTypes.size();
    }
}
