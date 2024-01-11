import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private String customerName;
    private final List<Pizza> pizzas = new ArrayList<>();

    private PizzaOrder() {
        // Private constructor to enforce usage of createOrder().
    }

    public static PizzaOrder createOrder() {
        return new PizzaOrder();
    }

    public PizzaOrder forCustomer(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null.");
        }

        this.customerName = customerName;
        return this;
    }

    public PizzaOrder addPizza(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("Pizza cannot be null.");
        }

        this.pizzas.add(pizza);
        return this;
    }

    public void printInvoice() {
        if (this.customerName == null) {
            throw new IllegalStateException("Customer name has not been set yet.");
        }

        System.out.println("\nCustomer: " + this.customerName);

        for (Pizza pizza : this.pizzas) {
            System.out.println("\nPizza " + pizza.getType().name() + ": "
                    + formatCurrency(pizza.getType().getPrice(pizza.getSize())) + " €");

            for (Topping topping : pizza.getToppings()) {
                System.out.println(" + " + topping.name() + ": " + formatCurrency(topping.getCost()) + " €");
            }
        }

        System.out.println("\nTotal: " + formatCurrency(this.calculateTotalCost()) + " €");
    }

    private double calculateTotalCost() {
        if (this.pizzas.isEmpty()) {
            return 0;
        }

        return this.pizzas.stream()
                .mapToDouble(Pizza::calculateCost)
                .sum();
    }

    private String formatCurrency(double amount) {
        return String.format("%,.2f", amount);
    }
}
