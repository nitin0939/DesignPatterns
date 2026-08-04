package designpatterns.behavioral.strategy;

/**
 * Strategy interface in the Strategy pattern (Head First's Duck Simulator example).
 * Encapsulates the "flying" family of algorithms so a {@link Duck} can hold
 * one of them and swap it out at runtime, instead of implementing flying
 * itself (or worse, inheriting it from a common superclass where not every
 * duck actually flies the same way).
 */
public interface FlyBehavior {

    /**
     * Performs this duck's flying behavior.
     */
    void fly();
}
