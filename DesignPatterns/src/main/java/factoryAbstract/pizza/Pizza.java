package factoryAbstract.pizza;

import factoryAbstract.ingredient.Cheese;
import factoryAbstract.ingredient.Dough;
import factoryAbstract.ingredient.Sauce;
import factoryAbstract.ingredient.Veggies;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Pizza {
    @Getter @Setter
    String name;

    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

}
