package factoryMethod.store;

import factoryMethod.pizza.MysuruStyleCheesePizza;
import factoryMethod.pizza.MysuruStylePepperoniPizza;
import factoryMethod.pizza.Pizza;

public class MysuruPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new MysuruStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new MysuruStylePepperoniPizza();
        } else
            return null;
    }
}
