package designpatterns.structural.adapter;

/**
 * Client class that demonstrates the Adapter pattern.
 * Shows a {@link WildTurkey} — whose interface duck-consuming code can't use
 * directly — being wrapped in a {@link TurkeyAdapter} so it can be passed
 * anywhere a {@link Duck} is expected.
 */
public class TestAdapter {

    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    /**
     * Code written against the {@link Duck} interface only — it has no idea
     * whether it's given a real {@link MallardDuck} or an adapted {@link WildTurkey}.
     */
    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
