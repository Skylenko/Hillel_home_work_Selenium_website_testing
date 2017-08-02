import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCase2 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDriver() {
        driver.close();
    }

    @Test
    public void doTest() throws InterruptedException {
       //1) зайти на сайт google
        driver.get("https://www.google.com");

        //2) ввести в поле слово Selenium
        WebElement inputWord = driver.findElement(By.xpath("//input[@id='lst-ib']"));
        inputWord.sendKeys("Selenium");
        inputWord.submit();

        //3) проверить, что каждая ссылка содержит слово Selenium
        List<WebElement> links = driver.findElements(By.xpath("//h3[@class='r']"));
        for (int i = 0; i < links.size(); i++) {
            Assert.assertTrue(links.get(i).getText().contains("Selenium"));
        }

        Thread.sleep(5000);
    }
}
