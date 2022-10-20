import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Возврат драйвера для конкретного браузера по его названию
    public static WebDriver getDriver(String browserName) {
        switch (browserName) {
            // Создание драйвера для браузера Google Chrome
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера Google Chrome");
                return new ChromeDriver();
            // Создание драйвера для браузера Mozilla Firefox
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "D:\\ucheba_soft\\geckodriver-v0.32.0-win64\\geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                logger.info("Драйвер для браузера Mozilla Firefox");
                return new FirefoxDriver(options) ;
            case "edge":
                WebDriverManager.edgedriver().setup();;
                logger.info("Драйвер браузера Microsoft Edge");
                return new EdgeDriver();
            // Ответ по умолчанию, если введено некорректное название браузера
            default:
                throw new RuntimeException("Введено некорректное название браузера");
        }
    }
}
