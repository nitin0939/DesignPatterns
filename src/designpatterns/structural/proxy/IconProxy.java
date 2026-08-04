package designpatterns.structural.proxy;

/**
 * Virtual Proxy in the Proxy pattern.
 * Stands in for a {@link RealIcon} that hasn't been created yet, deferring
 * the expensive download until the image is actually needed (its first
 * {@code draw()} call) rather than paying that cost the moment an album's
 * page is opened.
 */
public class IconProxy implements Icon {
    private RealIcon realIcon;
    private final String imageUrl;

    public IconProxy(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Creates the real icon on first use, then delegates to it. Every
     * subsequent call reuses the already-loaded {@link RealIcon} instead of
     * downloading again.
     */
    @Override
    public void draw() {
        if (realIcon == null) {
            System.out.println("(placeholder shown while loading...)");
            realIcon = new RealIcon(imageUrl);
        }
        realIcon.draw();
    }
}
