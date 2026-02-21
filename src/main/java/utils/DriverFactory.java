package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileNotFoundException;


public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private FileReader fileReader;


    public WebDriver getDriver() throws FileNotFoundException {
        if (driver.get() == null) {
            driver.set(getBrowser());
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();

        }
    }

    public WebDriver getBrowser() throws FileNotFoundException {
        String browser = new FileReader().getConfigValue("browser");
        switch(browser){
            case "Chrome":
                return new ChromeDriver();
            case "Edge":
                return new EdgeDriver();
            case "ChromeRemote":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); // Required for GitHub Actions
                options.addArguments("--no-sandbox");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }
}