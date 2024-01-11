public enum PizzaType {
    MARGHERITA(8.99),
    PEPPERONI(9.99),
    TUNA(10.99);

    private final double basePrice;

    PizzaType(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getPrice(Size size) {
        return switch (size) {
            case SMALL  -> basePrice;
            case MEDIUM -> basePrice + 2.00;
            case LARGE  -> basePrice + 4.00;
        };
    }
}

