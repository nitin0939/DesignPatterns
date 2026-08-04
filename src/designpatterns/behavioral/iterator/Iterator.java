package designpatterns.behavioral.iterator;

/**
 * Iterator in the Iterator pattern (Head First's Pancake House / Diner Menu
 * example). Gives sequential access to a collection's elements without
 * exposing whether that collection is backed by an array, an {@code ArrayList},
 * or anything else.
 */
public interface Iterator {

    boolean hasNext();

    MenuItem next();
}
