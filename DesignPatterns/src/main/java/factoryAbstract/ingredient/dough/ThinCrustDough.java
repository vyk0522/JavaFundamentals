package factoryAbstract.ingredient.dough;

import factoryAbstract.ingredient.Dough;

public class ThinCrustDough implements Dough {
    @Override
    public String description() {
        return "Thin Crust Dough";
    }
}
