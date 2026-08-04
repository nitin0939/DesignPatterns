package designpatterns.behavioral.visitor;

/**
 * Concrete Visitor in the Visitor pattern.
 * A new operation over the menu tree — total pricing — added without a
 * single change to {@link MenuItem} or {@link Menu}.
 */
public class PricingVisitor implements MenuVisitor {
    private double total = 0;

    @Override
    public void visit(MenuItem item) {
        total += item.getPrice();
    }

    @Override
    public void visit(Menu menu) {
        // Sub-menus contribute nothing directly; their items are visited
        // individually as Menu.accept() recurses into them.
    }

    public double getTotal() {
        return total;
    }
}
