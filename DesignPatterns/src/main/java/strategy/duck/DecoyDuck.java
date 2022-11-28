package strategy.duck;

import strategy.behavior.quack.MuteQuack;
import strategy.behavior.fly.NoFly;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new NoFly());
        setQuackBehavior(new MuteQuack());
    }

    public void display() {
        System.out.println("I'm a duck Decoy");
    }
}
