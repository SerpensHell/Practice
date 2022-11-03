import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TasksWaitsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ImplicitWaitsTest.class);

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
    public void implicitlyWaitTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.citilink.ru/");
        logger.info("Открыта страница Ситилинк -https://www.citilink.ru/");

        WebElement linkCatalog = driver.findElement(By.xpath("//button[@data-label = 'Каталог товаров']"));
        linkCatalog.click();
        logger.info("Открыто меню каталог товаров");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement linkCategory = driver.findElement(By.xpath("//a[@data-title = 'Ноутбуки и компьютеры']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(linkCategory).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement linkLaptop = driver.findElement(By.xpath("//a[@data-title = 'Недорогие ноутбуки']"));
        linkLaptop.click();

        WebElement productElement = driver.findElement(By.xpath("//a[text() = 'Ноутбук Digma EVE 15 P417, ES5063EW,  темно-серый']"));
        productElement.click();

        List<WebElement> propertyValues = driver.findElements(By.className("ProductPageMainPropertiesSection__property-value"));

        for (WebElement value : propertyValues) {
            String valueText = value.getText();
            logger.info(valueText);
        }
    }

    @Test
    public void explicitWaitTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.get("https://www.citilink.ru/");
        logger.info("Открыта страница Ситилинк -https://www.citilink.ru/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By linkCatalog = By.xpath("//button[@data-label = 'Каталог товаров']");
        WebElement linkCatalogButton = driver.findElement(linkCatalog);
        wait.until(ExpectedConditions.elementToBeClickable(linkCatalogButton));
        linkCatalogButton.click();
        logger.info("Открыто меню каталог товаров");

        WebElement linkCategory = driver.findElement(By.xpath("//a[@data-title = 'Ноутбуки и компьютеры']"));
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(linkCategory));
        actions.moveToElement(linkCategory).perform();

        By linkLaptop = By.xpath("//a[@data-title = 'Недорогие ноутбуки']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkLaptop));
        WebElement laptopButton = driver.findElement(linkLaptop);
        laptopButton.click();

        By productElement = By.xpath("//a[text() = 'Ноутбук Digma EVE 15 P417, ES5063EW,  темно-серый']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productElement));
        WebElement productButton = driver.findElement(productElement);
        productButton.click();

        By propertyValues = By.className("ProductPageMainPropertiesSection__property-value");
        wait.until(ExpectedConditions.visibilityOfElementLocated(propertyValues));
        List<WebElement> propertyValuesList = driver.findElements(propertyValues);

        for (WebElement value : propertyValuesList) {
            String valueText = value.getText();
            logger.info(valueText);
        }
    }

    @Test
    public void sleepWaitTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.get("https://www.citilink.ru/");
        logger.info("Открыта страница Ситилинк -https://www.citilink.ru/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement linkCatalog = driver.findElement(By.xpath("//button[@data-label = 'Каталог товаров']"));
        linkCatalog.click();
        logger.info("Открыто меню каталог товаров");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement linkCategory = driver.findElement(By.xpath("//a[@data-title = 'Ноутбуки и компьютеры']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(linkCategory).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement linkLaptop = driver.findElement(By.xpath("//a[@data-title = 'Недорогие ноутбуки']"));
        linkLaptop.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement productElement = driver.findElement(By.xpath("//a[text() = 'Ноутбук Digma EVE 15 P417, ES5063EW,  темно-серый']"));
        productElement.click();

        List<WebElement> propertyValues = driver.findElements(By.className("ProductPageMainPropertiesSection__property-value"));

        for (WebElement value : propertyValues) {
            String valueText = value.getText();
            logger.info(valueText);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void explicitAndCustomWaitTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.get("https://www.citilink.ru/");
        logger.info("Открыта страница Ситилинк -https://www.citilink.ru/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By linkCatalog = By.xpath("//button[@data-label = 'Каталог товаров']");
        WebElement linkCatalogButton = driver.findElement(linkCatalog);
        wait.until(ExpectedConditions.elementToBeClickable(linkCatalogButton));
        linkCatalogButton.click();
        logger.info("Открыто меню каталог товаров");

        WebElement linkCategory = driver.findElement(By.xpath("//a[@data-title = 'Ноутбуки и компьютеры']"));
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(linkCategory));
        actions.moveToElement(linkCategory).perform();

        By linkLaptop = By.xpath("//a[@data-title = 'Недорогие ноутбуки']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkLaptop));
        WebElement laptopButton = driver.findElement(linkLaptop);
        laptopButton.click();

        By productElement = By.xpath("//a[text() = 'Ноутбук Digma EVE 15 P417, ES5063EW,  темно-серый']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productElement));
        WebElement productButton = driver.findElement(productElement);
        productButton.click();

        By propertyValues = By.className("ProductPageMainPropertiesSection__property-value");
        wait.until(ExpectedConditions.visibilityOfElementLocated(propertyValues));
        List<WebElement> propertyValuesList = driver.findElements(propertyValues);

        for (WebElement value : propertyValuesList) {
            String valueText = value.getText();
            logger.info(valueText);
        }
    }*/
}
