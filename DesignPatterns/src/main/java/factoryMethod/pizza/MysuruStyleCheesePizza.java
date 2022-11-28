package factoryMethod.pizza;

public class MysuruStyleCheesePizza extends Pizza{
    public MysuruStyleCheesePizza() {
        name = "Mysuru Style Cheese Pizza";
        dough = "Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
