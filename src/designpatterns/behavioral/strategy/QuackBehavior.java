package designpatterns.behavioral.strategy;

/**
 * Strategy interface in the Strategy pattern.
 * Encapsulates the "quacking" family of algorithms so a {@link Duck} can hold
 * one of them and swap it out at runtime.
 */
public interface QuackBehavior {

    /**
     * Performs this duck's quacking behavior.
     */
    void quack();
}
