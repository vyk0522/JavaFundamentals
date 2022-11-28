package strategy.behavior.fly;

public class SlowFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with normal speed!!");
    }
}
