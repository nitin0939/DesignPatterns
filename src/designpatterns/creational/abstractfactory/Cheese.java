package designpatterns.creational.abstractfactory;

/**
 * Abstract Product in the Abstract Factory pattern.
 * Every regional cheese must be able to describe itself.
 */
public interface Cheese {

    /**
     * @return a short description of this cheese.
     */
    String describe();
}
