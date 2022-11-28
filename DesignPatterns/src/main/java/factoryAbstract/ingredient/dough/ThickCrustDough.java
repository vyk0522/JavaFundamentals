package factoryAbstract.ingredient.dough;

import factoryAbstract.ingredient.Dough;

public class ThickCrustDough implements Dough {
    @Override
    public String description() {
        return "ThickCrust style extra thick crust dough";
    }
}
