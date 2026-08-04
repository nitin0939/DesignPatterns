package designpatterns.behavioral.visitor;

/**
 * Element (abstract) in the Visitor pattern.
 * Every node in the menu tree can {@link #accept(MenuVisitor)} a visitor —
 * that one method is the entire hook new operations need; it never has to
 * change again as new visitors are added.
 */
public abstract class MenuComponent {

    public abstract void accept(MenuVisitor visitor);
}
