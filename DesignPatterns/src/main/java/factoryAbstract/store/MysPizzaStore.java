package factoryAbstract.store;

import factoryAbstract.factory.MysPizzaIngredientFactory;
import factoryAbstract.factory.PizzaIngredientFactory;
import factoryAbstract.pizza.CheesePizza;
import factoryAbstract.pizza.Pizza;
import factoryAbstract.pizza.VeggiePizza;

public class MysPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new MysPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Mysuru Style Cheese Pizza");

        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Mysuru Style Veggie Pizza");

        }
        return pizza;
    }
}
