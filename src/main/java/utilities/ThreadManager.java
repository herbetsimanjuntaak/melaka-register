package utilities;

import org.openqa.selenium.WebDriver;

public class ThreadManager {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final ThreadLocal<String> browser = new ThreadLocal<>();

    /**
     * Set webDriver
     * @param driver the WebDriver instance to set
     */
    public static synchronized  void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    /**
     * Get webDriver
     * @return the WebDriver instance
     */
    public static synchronized WebDriver getDriver() {
        return webDriver.get();
    }

    /**
     * Set browser
     * @param browserName the name of the browser to set
     */
    public static synchronized void setBrowser(String browserName) {
        browser.set(browserName);
    }

    /**
     * Get browser
     * @return the name of the browser
     */
    public static synchronized String getBrowser() {
        return browser.get();
    }

}
