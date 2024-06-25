package utils;

import org.junit.Before;
import org.picocontainer.MutablePicoContainer;

public class PicoContainerSteps {
    private MutablePicoContainer container;

    public PicoContainerSteps(){
        this.container = DependencyInjector.getContainer();
    }

    @Before
    public void setup(){

    }
}
