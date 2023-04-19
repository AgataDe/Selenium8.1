package cofiguration.browser;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    EDGE("edge");

    public String getBrowserName() {
        return browserName;
    }

    private String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }
}
