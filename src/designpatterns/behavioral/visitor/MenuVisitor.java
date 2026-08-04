package designpatterns.behavioral.visitor;

/**
 * Visitor in the Visitor pattern.
 * (Head First Design Patterns only covers Visitor briefly, in its "leftover
 * patterns" chapter, without a fully worked example — this is a book-style
 * example built for this repo, reusing its own Diner Menu tree domain,
 * not a verbatim book example.)
 * Declares one overload per node type in the menu tree. Each concrete
 * visitor is a new *operation* over the tree, written without touching
 * {@link MenuItem} or {@link Menu} themselves.
 */
public interface MenuVisitor {

    void visit(MenuItem item);

    void visit(Menu menu);
}
