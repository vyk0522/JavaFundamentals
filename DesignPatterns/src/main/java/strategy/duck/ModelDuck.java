package strategy.duck;

import strategy.behavior.fly.NoFly;
import strategy.behavior.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new NoFly();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}