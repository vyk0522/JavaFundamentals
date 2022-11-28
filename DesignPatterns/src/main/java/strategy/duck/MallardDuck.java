package strategy.duck;

import strategy.behavior.quack.Quack;
import strategy.behavior.fly.SlowFly;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new SlowFly();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
