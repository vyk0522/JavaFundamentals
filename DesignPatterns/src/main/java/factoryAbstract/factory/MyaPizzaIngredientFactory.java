package factoryAbstract.factory;

import factoryAbstract.ingredient.Cheese;
import factoryAbstract.ingredient.Dough;
import factoryAbstract.ingredient.Sauce;
import factoryAbstract.ingredient.Veggies;
import factoryAbstract.ingredient.cheese.MozzarellaCheese;
import factoryAbstract.ingredient.dough.ThickCrustDough;
import factoryAbstract.ingredient.sauce.TomatoSauce;
import factoryAbstract.ingredient.vegetable.Garlic;
import factoryAbstract.ingredient.vegetable.Onion;
import factoryAbstract.ingredient.vegetable.Spinach;

public class MyaPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new TomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Onion(), new Spinach(), new Garlic() };
        return veggies;
    }
}
