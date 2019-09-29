package testsuite;

import framework.Config;

import org.testng.annotations.Test;

public class DummyTest extends Config {

    @Test
    public void googleTest() {

        google.enterAndSubmitSearch("Hello, automation!");
    }
}
