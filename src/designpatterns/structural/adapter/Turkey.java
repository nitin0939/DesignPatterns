package designpatterns.structural.adapter;

/**
 * Adaptee in the Adapter pattern.
 * A perfectly usable interface — but incompatible with {@link Duck}, since it
 * exposes {@code gobble()} instead of {@code quack()}, and its {@code fly()}
 * only covers short distances.
 */
public interface Turkey {

    /**
     * Makes the turkey's characteristic sound.
     */
    void gobble();

    /**
     * Makes the turkey fly — turkeys can only fly short distances, unlike ducks.
     */
    void fly();
}
