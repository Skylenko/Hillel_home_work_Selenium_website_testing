import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
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
        //1) зайти на сайт seleniumhq.org
        driver.get("http://www.seleniumhq.org");

        //2) нажать на кнопку download
        WebElement button = driver.findElement(By.xpath("//a[@title='Get Selenium']"));
        button.click();

        //3) проверить наличие слова Java на странице
        WebElement actualText = driver.findElement(By.xpath("//*[contains(text(), 'Java')]"));

        Assert.assertEquals("Java", actualText.getText());

        //4) нажать на кнопку download напротив Java
        WebElement buttonDownload = driver.findElement(By.xpath("//*[@id='mainContent']/table[1]/tbody/tr[1]/td[4]/a"));
        buttonDownload.click();

        Thread.sleep(5000);
    }
}
