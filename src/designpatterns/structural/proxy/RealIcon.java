package designpatterns.structural.proxy;

/**
 * Real Subject in the Proxy pattern.
 * Simulates an album cover image that's genuinely expensive to obtain (e.g.
 * downloaded over a network) — the cost is paid once, in the constructor.
 */
public class RealIcon implements Icon {
    private final String imageUrl;

    /**
     * Simulates a slow network fetch, paid once per instance.
     */
    public RealIcon(String imageUrl) {
        this.imageUrl = imageUrl;
        System.out.println("Downloading album cover from " + imageUrl + " ...");
        System.out.println("Download complete.");
    }

    @Override
    public void draw() {
        System.out.println("Displaying album cover: " + imageUrl);
    }
}
