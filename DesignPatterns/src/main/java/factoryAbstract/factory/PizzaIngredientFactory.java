package factoryAbstract.factory;

import factoryAbstract.ingredient.Cheese;
import factoryAbstract.ingredient.Dough;
import factoryAbstract.ingredient.Sauce;
import factoryAbstract.ingredient.Veggies;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
}
