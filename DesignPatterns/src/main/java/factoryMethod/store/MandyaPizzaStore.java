package factoryMethod.store;

import factoryMethod.pizza.MandyaStyleCheesePizza;
import factoryMethod.pizza.MandyaStylePepperoniPizza;
import factoryMethod.pizza.MandyaStyleVeggiePizza;
import factoryMethod.pizza.Pizza;

public class MandyaPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new MandyaStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new MandyaStyleVeggiePizza();
        } else if (type.equals("pepperoni")) {
            return new MandyaStylePepperoniPizza();
        } else
            return null;
    }
}
