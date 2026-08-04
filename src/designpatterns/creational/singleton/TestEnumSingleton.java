package designpatterns.creational.singleton;

/**
 * Client class that demonstrates the enum Singleton variant using the
 * Chocolate Boiler example. Runs the fill/boil/drain cycle through one
 * reference and reads the resulting state back through another, proving
 * both point at the same shared boiler.
 */
public class TestEnumSingleton {

    public static void main(String[] args) {
        ChocolateBoilerEnum first = ChocolateBoilerEnum.INSTANCE;
        ChocolateBoilerEnum second = ChocolateBoilerEnum.INSTANCE;

        System.out.println("Same instance? " + (first == second));

        first.fill();
        first.boil();
        System.out.println("Boiled, seen via second reference: " + second.isBoiled());
        second.drain();
        System.out.println("Empty, seen via first reference: " + first.isEmpty());
    }
}
