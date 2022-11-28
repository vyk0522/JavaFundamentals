package factoryAbstract;

import factoryAbstract.pizza.Pizza;
import factoryAbstract.store.MyaPizzaStore;
import factoryAbstract.store.MysPizzaStore;
import factoryAbstract.store.PizzaStore;

public class PizzaManager {
    public static void main(String[] args) {
        PizzaStore myaPizzaStore = new MyaPizzaStore();
        PizzaStore mysPizzaStore = new MysPizzaStore();

        Pizza pizza = myaPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza + "\n");

        pizza = mysPizzaStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza + "\n");

        pizza = myaPizzaStore.orderPizza("veggie");
        System.out.println("Ethan ordered a " + pizza + "\n");

        pizza = mysPizzaStore.orderPizza("veggie");
        System.out.println("Joel ordered a " + pizza + "\n");
    }
}
