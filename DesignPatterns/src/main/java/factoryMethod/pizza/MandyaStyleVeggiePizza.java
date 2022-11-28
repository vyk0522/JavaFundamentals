package factoryMethod.pizza;

public class MandyaStyleVeggiePizza extends Pizza{
    public MandyaStyleVeggiePizza() {
        name = "Mandya Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }
}
