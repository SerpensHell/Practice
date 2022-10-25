import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CssSelectorsTrainingTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(CssSelectorsTrainingTest.class);

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

        String query = "div.PopularCategoriesBox__content > div:first-of-type";
        List<WebElement> elements = driver.findElements(By.cssSelector(query));
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
