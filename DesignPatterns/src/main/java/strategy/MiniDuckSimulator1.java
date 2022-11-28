package strategy;

import strategy.behavior.fly.FastFly;
import strategy.behavior.fly.FlyBehavior;
import strategy.behavior.quack.QuackBehavior;
import strategy.duck.*;

public class MiniDuckSimulator1 {
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        FlyBehavior cantFly = () -> System.out.println("I can't fly");
        QuackBehavior squeak = () -> System.out.println("Squeak");
        RubberDuck rubberDuckie = new RubberDuck(cantFly, squeak);
        DecoyDuck decoy = new DecoyDuck();

        Duck model = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        model.performFly();
        model.setFlyBehavior(new FastFly());
        model.performFly();
    }
}
