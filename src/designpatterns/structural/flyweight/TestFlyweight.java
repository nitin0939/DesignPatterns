package designpatterns.structural.flyweight;

/**
 * Client class that demonstrates the Flyweight pattern.
 * Plants many trees of only two species, then shows that only two
 * {@link TreeType} flyweights were ever created despite the larger number of
 * {@link Tree} instances.
 */
public class TestFlyweight {

    public static void main(String[] args) {
        Forest forest = new Forest();

        forest.plantTree(1, 1, "Oak", "Green", "Rough");
        forest.plantTree(2, 5, "Oak", "Green", "Rough");
        forest.plantTree(7, 3, "Oak", "Green", "Rough");
        forest.plantTree(4, 8, "Pine", "Dark Green", "Needled");
        forest.plantTree(9, 2, "Pine", "Dark Green", "Needled");

        forest.draw();

        System.out.println("\nTrees planted: " + forest.getTreeCount());
        System.out.println("TreeType flyweights actually created: " + TreeFactory.getCreatedTypeCount());
    }
}
