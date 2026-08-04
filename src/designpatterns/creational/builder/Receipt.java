package designpatterns.creational.builder;

import java.util.List;

/**
 * Product in the Builder pattern.
 * A different product entirely from {@link Beverage}, assembled from the
 * exact same part values via {@link ReceiptBuilder} — this is what shows a
 * single {@link Barista} recipe can build unrelated product types.
 */
public class Receipt {
    private final String name;
    private final Size size;
    private final List<String> condiments;

    /**
     * Wires all pre-built parts together into a finished receipt.
     */
    public Receipt(String name, Size size, List<String> condiments) {
        this.name = name;
        this.size = size;
        this.condiments = condiments;
    }

    /**
     * Formats a human-readable order ticket for the beverage that was ordered.
     */
    public String print() {
        String info = "";
        info += "Beverage: " + name + "\n";
        info += "Size: " + size + "\n";
        info += "Condiments: " + (condiments.isEmpty() ? "None" : condiments) + "\n";
        return info;
    }
}
