package designpatterns.creational.singleton;

/**
 * Client class that demonstrates the eager-initialization Singleton variant
 * using the Chocolate Boiler example.
 */
public class TestEagerSingleton {

    public static void main(String[] args) {
        EagerChocolateBoiler first = EagerChocolateBoiler.getInstance();
        EagerChocolateBoiler second = EagerChocolateBoiler.getInstance();

        System.out.println("Same instance? " + (first == second));

        first.fill();
        second.boil();
        second.drain();
    }
}
