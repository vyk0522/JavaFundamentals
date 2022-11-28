package factorySimple;

import factoryMethod.pizza.MandyaStyleCheesePizza;
import factoryMethod.pizza.MandyaStylePepperoniPizza;
import factoryMethod.pizza.Pizza;

public class PizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new MandyaStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new MandyaStylePepperoniPizza();
        }

        return pizza;
    }
}
