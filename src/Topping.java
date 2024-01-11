public enum Topping {
    EXTRA_CHEESE(1.50),
    MUSHROOMS(1.00),
    OLIVES(0.75);

    private final double cost;

    Topping(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}