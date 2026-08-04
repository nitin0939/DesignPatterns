package designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Builder in the Builder pattern.
 * Accumulates the same parts as {@link BeverageBuilder}, but assembles them
 * into a printed {@link Receipt} instead of an actual drink — proving the
 * same {@link Barista} recipe can produce entirely different product types.
 */
public class ReceiptBuilder implements OrderBuilder {
    private String name;
    private Size size;
    private final List<String> condiments = new ArrayList<>();

    @Override
    public void setBeverageName(String name) {
        this.name = name;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public void addCondiment(String condiment) {
        this.condiments.add(condiment);
    }

    /**
     * Assembles and returns the final {@link Receipt} from all parts set so far.
     */
    public Receipt getResult() {
        return new Receipt(name, size, condiments);
    }
}
