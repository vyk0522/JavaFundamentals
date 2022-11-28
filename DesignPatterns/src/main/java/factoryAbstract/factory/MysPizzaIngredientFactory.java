package factoryAbstract.factory;

import factoryAbstract.ingredient.Cheese;
import factoryAbstract.ingredient.Dough;
import factoryAbstract.ingredient.Sauce;
import factoryAbstract.ingredient.Veggies;
import factoryAbstract.ingredient.cheese.ReggianoCheese;
import factoryAbstract.ingredient.dough.ThinCrustDough;
import factoryAbstract.ingredient.sauce.MarinaraSauce;
import factoryAbstract.ingredient.vegetable.Garlic;
import factoryAbstract.ingredient.vegetable.Onion;
import factoryAbstract.ingredient.vegetable.RedPepper;

public class MysPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new RedPepper() };
        return veggies;
    }
}
