package designpatterns.creational.abstractfactory;

/**
 * Abstract Product in the Abstract Factory pattern.
 * Every regional dough must be able to describe itself.
 */
public interface Dough {

    /**
     * @return a short description of this dough.
     */
    String describe();
}
