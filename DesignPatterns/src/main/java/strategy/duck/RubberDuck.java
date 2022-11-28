package strategy.duck;

import strategy.behavior.fly.FlyBehavior;
import strategy.behavior.fly.NoFly;
import strategy.behavior.quack.QuackBehavior;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new NoFly();
        //quackBehavior = new Squeak();
        quackBehavior = () -> System.out.println("Squeak");
    }

    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void display() {
        System.out.println("I'm a rubber duckie");
    }
}
