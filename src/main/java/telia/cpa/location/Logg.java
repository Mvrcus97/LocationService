package telia.cpa.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author srccodes.com
 * @version 1.0
 */
public class Logg {
    private final Logger slf4jLogger = LoggerFactory.getLogger(Logg.class);

    /**
     * Print hello in log.
     *
     * @param name
     */
    public void sayHello(String name) {
        slf4jLogger.info("Hi, {}", name);
        slf4jLogger.info("Welcome to the HelloWorld example of SLF4J");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Logg slf4jHello = new Logg();
        slf4jHello.sayHello("Marcus");
    }
}