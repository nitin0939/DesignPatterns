package designpatterns.structural.proxy;

/**
 * Client class that demonstrates the Proxy pattern.
 * Creates icons for several albums instantly (no download happens yet), then
 * shows the real download only kicking in the first time each one is drawn.
 */
public class TestProxy {

    public static void main(String[] args) {
        System.out.println("Creating album icons (no downloads should happen yet)...");
        Icon coverOne = new IconProxy("http://albums.example.com/dark-side-of-the-moon.jpg");
        Icon coverTwo = new IconProxy("http://albums.example.com/abbey-road.jpg");
        System.out.println("Icons created.\n");

        System.out.println("Drawing cover one (first time — triggers download):");
        coverOne.draw();

        System.out.println("\nDrawing cover one again (already loaded, no re-download):");
        coverOne.draw();

        System.out.println("\nDrawing cover two (first time — triggers download):");
        coverTwo.draw();
    }
}
