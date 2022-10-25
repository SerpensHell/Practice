import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class XpathSelectorsTrainingTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(XpathSelectorsTrainingTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
    @Test
    public void searchSomethingTest(){
        driver.get("https://www.citilink.ru/");
        logger.info("Открыта страница Ситилинк - " + "https://www.citilink.ru/");

        String query = "(//a[@class = ' ProductCardVertical__link link_gtm-js  Link js--Link Link_type_default'])[2]";
        List<WebElement> elements = driver.findElements(By.xpath(query));
        for (WebElement element : elements) {
            logger.info("WebElement: " + element.getTagName() + " = " + element.getText());
        }
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}