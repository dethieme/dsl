public class Main {
    public static void main(String[] args) {
        PizzaOrder order = PizzaOrder.createOrder()
                .forCustomer("Denise Thieme")
                .addPizza(
                        Pizza.createPizza()
                                .size(Size.MEDIUM)
                                .type(PizzaType.MARGHERITA)
                                .addTopping(Topping.EXTRA_CHEESE)
                                .addTopping(Topping.MUSHROOMS)
                )
                .addPizza(
                        Pizza.createPizza()
                                .size(Size.LARGE)
                                .type(PizzaType.PEPPERONI)
                                .addTopping(Topping.MUSHROOMS)
                                .addTopping(Topping.OLIVES)
                );

        order.printInvoice();

        order = PizzaOrder.createOrder()
                .forCustomer("Max Mustermann")
                .addPizza(
                        Pizza.createPizza()
                                .type(PizzaType.TUNA)
                                .size(Size.SMALL)
                                .addTopping(Topping.EXTRA_CHEESE)
                                .addTopping(Topping.MUSHROOMS)
                                .addTopping(Topping.OLIVES)
                );

        order.printInvoice();
    }
}