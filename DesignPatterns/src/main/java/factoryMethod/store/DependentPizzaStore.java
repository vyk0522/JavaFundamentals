package factoryMethod.store;

import factoryMethod.pizza.*;

public class DependentPizzaStore {

    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if (style.equals("MYS")) {
            if (type.equals("cheese")) {
                return new MysuruStyleCheesePizza();
            } else if (type.equals("pepperoni")) {
                return new MysuruStylePepperoniPizza();
            }
        } else if (style.equals("MYA")) {
            if (type.equals("cheese")) {
                return new MandyaStyleCheesePizza();
            } else if (type.equals("veggie")) {
                return new MandyaStyleVeggiePizza();
            } else if (type.equals("pepperoni")) {
                return new MandyaStylePepperoniPizza();
            }
        } else {
            System.out.println("Error: invalid type of pizza");
            return null;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
