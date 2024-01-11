import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Size size = Size.SMALL;
    private PizzaType type = PizzaType.MARGHERITA;
    private final List<Topping> toppings = new ArrayList<>();

    private Pizza() {
        // Private constructor to enforce usage of createPizza().
    }

    public static Pizza createPizza() {
        return new Pizza();
    }

    public Pizza type(PizzaType type) {
        if (type == null) {
            throw new IllegalArgumentException("Pizza type cannot be null.");
        }

        this.type = type;
        return this;
    }

    public Pizza size(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("Pizza size cannot be null.");
        }

        this.size = size;
        return this;
    }

    public Pizza addTopping(Topping topping) {
        if (topping == null) {
            throw new IllegalArgumentException("Pizza topping cannot be null.");
        }

        this.toppings.add(topping);
        return this;
    }

    public double calculateCost() {
        if (this.type == null || this.size == null) {
            throw new IllegalStateException("Not all attributes are set.");
        }

        double baseCost = this.type.getPrice(this.size);
        double toppingsCost = this.toppings.stream()
                .mapToDouble(Topping::getCost)
                .sum();

        return baseCost + toppingsCost;
    }

    public PizzaType getType() {
        return this.type;
    }

    public Size getSize() {
        return this.size;
    }

    public List<Topping> getToppings() {
        return new ArrayList<>(this.toppings);
    }
}