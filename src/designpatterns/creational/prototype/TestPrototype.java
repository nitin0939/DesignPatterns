package designpatterns.creational.prototype;

/**
 * Client class that demonstrates the Prototype pattern.
 * Fetches clones from the {@link DuckPond} and proves that mutating a clone
 * never affects the cached prototype or any other clone taken from it.
 */
public class TestPrototype {

    /**
     * Stocks the duck pond, clones two ducks from it, mutates one clone,
     * and clones the same prototype again to show the pond stayed untouched.
     */
    public static void main(String[] args) {
        DuckPond.stockPond();

        Duck clonedMallard = DuckPond.getDuck("Mallard");
        Duck clonedRubber = DuckPond.getDuck("Rubber");

        System.out.println("Cloned duck: " + clonedMallard);
        clonedMallard.quack();
        System.out.println("Cloned duck: " + clonedRubber);
        clonedRubber.quack();

        clonedMallard.name = "Donald";
        System.out.println("\nRenamed clone: " + clonedMallard);

        Duck freshMallard = DuckPond.getDuck("Mallard");
        System.out.println("Fresh clone from pond (unaffected): " + freshMallard);
    }
}
