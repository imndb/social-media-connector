package ch.imndb.social;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class StartFB {

    static WebDriver driver;

    public static boolean driverStarted = false;

    public static final String NEW_POST_TEXT = "Was machst du gerade, ";
    public static final String NAME = "name?";

    public static void runFB() throws InterruptedException {

        useExistingChrome();

        //waitForSelenium();

        driver.get("https://www.facebook.com");

        waitForSelenium();


        By bySpanText = By.xpath("//span[text()='" + NEW_POST_TEXT + NAME + "']");

        WebElement element = driver.findElement(bySpanText);
        if (element == null)
            throw new RuntimeException("post not found");
        element.click();

        waitForSelenium();


    }

    private static void useExistingChrome() {

        ChromeOptions options;
        if (driverStarted) {
            options = new ChromeOptions();
            options.addArguments("--remote-debugging-port=9222");
            options = new ChromeOptions();
            options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
            options.addArguments("--user-data-dir=\"~/ChromeProfile\"");


            // System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver(options);
            System.out.println(driver.getTitle());

        } else {
            driver = new ChromeDriver();
            driverStarted = true;

        }

    }

    private static void waitForSelenium() throws InterruptedException {
        driver.wait(10000);
    }


}
