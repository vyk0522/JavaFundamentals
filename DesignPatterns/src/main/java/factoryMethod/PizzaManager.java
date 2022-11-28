package factoryMethod;

import factoryMethod.pizza.Pizza;
import factoryMethod.store.MandyaPizzaStore;
import factoryMethod.store.MysuruPizzaStore;
import factoryMethod.store.PizzaStore;

public class PizzaManager {
    public static void main(String[] args) {
        PizzaStore mysStore = new MysuruPizzaStore();
        PizzaStore myaStore = new MandyaPizzaStore();

        Pizza pizza = mysStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = myaStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = mysStore.orderPizza("pepperoni");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = myaStore.orderPizza("pepperoni");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
