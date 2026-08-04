package designpatterns.creational.builder;

/**
 * Director in the Builder pattern.
 * Knows the exact recipe for each drink on the menu, but delegates the actual
 * part construction to whichever {@link OrderBuilder} it is given — so the
 * same recipe can produce a {@link Beverage} or a {@link Receipt}.
 */
public class Barista {

    /**
     * Drives {@code builder} through the steps that make a grande dark roast with whip.
     */
    public void constructDarkRoastWithWhip(OrderBuilder builder) {
        builder.setBeverageName("Dark Roast");
        builder.setSize(Size.GRANDE);
        builder.addCondiment("Whip");
    }

    /**
     * Drives {@code builder} through the steps that make a venti iced house blend.
     */
    public void constructHouseBlendIced(OrderBuilder builder) {
        builder.setBeverageName("House Blend");
        builder.setSize(Size.VENTI);
        builder.addCondiment("Ice");
    }

    /**
     * Drives {@code builder} through the steps that make a plain tall espresso
     * (no condiments).
     */
    public void constructEspressoDouble(OrderBuilder builder) {
        builder.setBeverageName("Espresso");
        builder.setSize(Size.TALL);
    }
}
