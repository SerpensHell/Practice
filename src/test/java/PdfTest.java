import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PrintOptions;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(PdfTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public <PDDocument> void pdfTextPdfBoxTest() {
        // Открыть страницу с PDF
        String pdfURL = "http://www.pdf995.com/samples/pdf.pdf";
        driver.get(pdfURL);

        try {
            // Открытие файла PDF
            PDDocument pdf = PDDocument.load(new BufferedInputStream(new URL(pdfURL).openStream()));
            // Извлечение текста из документа PDF
            String text = new PDFTextStripper().getText(pdf);
            logger.info(text);
            // Закрытие файла PDF
            pdf.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

