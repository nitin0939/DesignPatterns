package designpatterns.structural.proxy;

/**
 * Subject in the Proxy pattern (Head First's virtual-proxy album-cover example).
 * Both the real, slow-to-load image and its lightweight stand-in share this
 * interface, so a client can hold either one interchangeably.
 */
public interface Icon {

    void draw();
}
