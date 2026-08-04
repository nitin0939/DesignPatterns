package designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Builder in the Builder pattern.
 * Accumulates the parts set by the {@link Barista} and assembles them into
 * a real, servable {@link Beverage}.
 */
public class BeverageBuilder implements OrderBuilder {
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
     * Assembles and returns the final {@link Beverage} from all parts set so far.
     */
    public Beverage getResult() {
        return new Beverage(name, size, condiments);
    }
}
