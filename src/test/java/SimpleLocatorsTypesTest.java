import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleLocatorsTypesTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SimpleLocatorsTypesTest.class);

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
    public void searchByIdTest(){
        driver.get("https://www.dns-shop.ru/?city=belgorod");
        logger.info("Открыта страница https://www.dns-shop.ru/?city=belgorod - " + "https://www.dns-shop.ru/?city=belgorod");
        // Поиск элемента по атрибуту id элемента
        WebElement element = driver.findElement(By.id("homepage-banners-slider-5cdc2373-717d-42a2-be77-5076dc57acd5"));
        logger.info("WebElement: " + element.getTagName());
        //element.sendKeys("");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByNameTest(){
        driver.get("https://www.dns-shop.ru/?city=belgorod");
        logger.info("https://www.dns-shop.ru/?city=belgorod - " + "https://www.dns-shop.ru/?city=belgorod");
        // Поиск элемента по атрибуту name элемента
        WebElement element = driver.findElement(By.name("q"));
        logger.info("WebElement: " + element.getTagName());
        element.sendKeys("Samsung");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByClassTest(){
        driver.get("https://www.dns-shop.ru/?city=belgorodn");
        logger.info("Открыта страница https://www.dns-shop.ru/?city=belgorod - " + "https://www.dns-shop.ru/?city=belgorod");
        // Поиск элемента по атрибуту class элемента
        List<WebElement> elements = driver.findElements(By.className("menu-mobile"));
        for(WebElement element : elements)
            logger.info("WebElement: " + element.getText());
    }

    @Test
    public void searchByTagTest(){
        driver.get("https://www.dns-shop.ru/?city=belgorodn");
        logger.info("Открыта страница https://www.dns-shop.ru/?city=belgorodn - " + "https://www.dns-shop.ru/?city=belgorodn");
        // Поиск элемента по тегу элемента
        List<WebElement> elements = driver.findElements(By.tagName("img"));
        for(WebElement element : elements)
            logger.info("WebElement: " + element.getText());
    }

    @Test
    public void searchByLinkTextTest(){
        driver.get("https://www.1tv.ru/news/2022-10-24/440187-sinoptiki_rasskazali_o_pogode_v_stolichnom_regione_na_predstoyaschey_nedele");
        logger.info("Открыта страница https://www.1tv.ru/news/2022-10-24/440187-sinoptiki_rasskazali_o_pogode_v_stolichnom_regione_na_predstoyaschey_nedele - " + "https://www.1tv.ru/news/2022-10-24/440187-sinoptiki_rasskazali_o_pogode_v_stolichnom_regione_na_predstoyaschey_nedele");
        // Поиск элемента по тексту ссылки
        WebElement element = driver.findElement(By.linkText("Все новости"));
        logger.info("WebElement: " + element.getText());
        element.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByPartialLinkTextTest(){
        driver.get("https://www.1tv.ru/news/2022-10-24/440187-sinoptiki_rasskazali_o_pogode_v_stolichnom_regione_na_predstoyaschey_nedele");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        // Поиск элемента по частичному тексту ссылки
        WebElement element = driver.findElement(By.partialLinkText("Полит"));
        logger.info("WebElement: " + element.getText());
        element.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByCssSelectorTest(){
        driver.get("https://www.dns-shop.ru/?city=belgorod");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        // Поиск элемента по CSS селектору
        WebElement element1 = driver.findElement(By.cssSelector("#homepage-banners-slider-5cdc2373-717d-42a2-be77-5076dc57acd5"));
        logger.info("WebElement: " + element1.getTagName());
        logger.info("Id: " + element1.getAttribute("id"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByXpathQueryTest(){
        driver.get("https://www.dns-shop.ru/?city=belgorod");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        // Поиск элемента по XPATH запросу
        WebElement element1 = driver.findElement(By.xpath(".//div[@id='homepage-banners-slider-5cdc2373-717d-42a2-be77-5076dc57acd5']"));
        logger.info("WebElement: " + element1.getTagName());
        logger.info("Id: " + element1.getAttribute("id"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
