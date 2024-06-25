package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

public class DependencyInjector {
    private static MutablePicoContainer container;

    static {
        container = new DefaultPicoContainer(new Caching());
        container.addComponent(WebDriver.class, ChromeDriver.class);
    }

    public static MutablePicoContainer getContainer(){
        return container;
    }
}
