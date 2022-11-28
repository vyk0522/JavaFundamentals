package factoryAbstract.store;

import factoryAbstract.factory.MyaPizzaIngredientFactory;
import factoryAbstract.factory.PizzaIngredientFactory;
import factoryAbstract.pizza.CheesePizza;
import factoryAbstract.pizza.Pizza;
import factoryAbstract.pizza.VeggiePizza;

public class MyaPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new MyaPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Mandya Style Cheese Pizza");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Mandya Style Veggie Pizza");

        }
        return pizza;

    }
}
