package cofiguration;

import cofiguration.model.Browser;
import cofiguration.model.Environment;
import cofiguration.model.TestData;

public class Config {
    public Browser browser;
    public Environment environment;
    public TestData testData;


    public Browser getBrowser() {
        return browser;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public TestData getTestData() {
        return testData;
    }
}
