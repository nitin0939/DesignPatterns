package designpatterns.structural.adapter;

/**
 * Target in the Adapter pattern (Head First's Duck/Turkey example).
 * The interface client code already knows how to work with.
 */
public interface Duck {

    /**
     * Makes the duck's characteristic sound.
     */
    void quack();

    /**
     * Makes the duck fly.
     */
    void fly();
}
