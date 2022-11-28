package factoryAbstract.ingredient.cheese;

import factoryAbstract.ingredient.Cheese;

public class MozzarellaCheese implements Cheese {
    @Override
    public String description() {
        return "Shredded Mozzarella";
    }
}
