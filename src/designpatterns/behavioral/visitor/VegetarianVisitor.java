package designpatterns.behavioral.visitor;

/**
 * Concrete Visitor in the Visitor pattern.
 * A second, independent operation over the same tree — printing every
 * vegetarian item found, at any depth.
 */
public class VegetarianVisitor implements MenuVisitor {

    @Override
    public void visit(MenuItem item) {
        if (item.isVegetarian()) {
            System.out.println(item.getName() + " is vegetarian");
        }
    }

    @Override
    public void visit(Menu menu) {
        System.out.println("Checking menu: " + menu.getName());
    }
}
