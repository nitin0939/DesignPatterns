package designpatterns.creational.singleton;

/**
 * Client class that demonstrates the Singleton pattern under concurrency.
 * Two threads race to call {@link ChocolateBoiler#getInstance()}; if the
 * pattern is implemented correctly, both end up holding a reference to the
 * exact same boiler, proven by comparing them once both threads finish.
 * The fill/boil/drain cycle itself is then demonstrated separately,
 * single-threaded, since those methods aren't synchronized and racing them
 * concurrently would be a thread-safety bug in its own right — not what
 * this example is about.
 */
public class TestSingleton {

    private static volatile ChocolateBoiler seenByFoo;
    private static volatile ChocolateBoiler seenByBar;

    /**
     * Starts two threads that each fetch the singleton, waits for both, then
     * confirms they got the same instance before running one full
     * fill/boil/drain cycle on the main thread.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
        threadFoo.join();
        threadBar.join();

        System.out.println("Same instance seen by both threads? " + (seenByFoo == seenByBar));

        System.out.println("\nRunning one fill/boil/drain cycle:");
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();
        boiler.boil();
        boiler.drain();
    }

    /**
     * Fetches the singleton and stashes it for the identity check in {@link #main}.
     */
    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            seenByFoo = ChocolateBoiler.getInstance();
        }
    }

    /**
     * Races {@link ThreadFoo} to fetch the same singleton.
     */
    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            seenByBar = ChocolateBoiler.getInstance();
        }
    }
}
