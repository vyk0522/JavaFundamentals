package factoryAbstract.ingredient.sauce;

import factoryAbstract.ingredient.Sauce;

public class TomatoSauce implements Sauce {
    @Override
    public String description() {
        return "Tomato sauce with plum tomatoes";
    }
}
