package strategy;

import strategy.behavior.fly.FastFly;
import strategy.duck.Duck;
import strategy.duck.MallardDuck;
import strategy.duck.RubberDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.swim();
        mallard.performFly();
        mallard.performQuack();
        System.out.println("------------------------------");

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.setFlyBehavior(new FastFly());
        rubberDuck.performFly();
    }
}
