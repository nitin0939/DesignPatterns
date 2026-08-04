package designpatterns.behavioral.visitor;

/**
 * Client class that demonstrates the Visitor pattern.
 * Builds one menu tree, then runs two completely different operations
 * ({@link PricingVisitor}, {@link VegetarianVisitor}) over it, without
 * either visitor requiring any change to {@link MenuItem} or {@link Menu}.
 */
public class TestVisitor {

    public static void main(String[] args) {
        Menu dinerMenu = new Menu("Diner Menu");
        dinerMenu.add(new MenuItem("Vegetarian BLT", true, 2.99));
        dinerMenu.add(new MenuItem("BLT", false, 2.99));

        Menu dessertMenu = new Menu("Dessert Menu");
        dessertMenu.add(new MenuItem("Apple Pie", true, 1.59));
        dinerMenu.add(dessertMenu);

        PricingVisitor pricingVisitor = new PricingVisitor();
        dinerMenu.accept(pricingVisitor);
        System.out.println("Total price of all items: $" + pricingVisitor.getTotal());

        System.out.println();
        VegetarianVisitor vegetarianVisitor = new VegetarianVisitor();
        dinerMenu.accept(vegetarianVisitor);
    }
}
