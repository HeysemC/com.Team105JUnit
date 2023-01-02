package testPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {


    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }
    @After
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);

        driver.close();
    }
    @Test
    public void test() throws InterruptedException {

        // 1- https://www.teknosa.com/ adresine gidin
        driver.get("https://teknosa.com/");

        // 2- Arama cubuguna "oppo" yazin
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

        // 3- Cikan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.className("plp-info"));
        System.out.println("Sonuc sayisi : " + sonucSayisi.getText());

        // 4- Cikan ilk urune tiklayin
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

        // 5- Sepete ekleyiniz
        WebElement sepeteEkle = driver.findElement(By.xpath("(//button[@data-product-id='125078080'])[1]"));
        sepeteEkle.sendKeys(Keys.PAGE_DOWN);

        Thread.sleep(2000);

        sepeteEkle.sendKeys(Keys.PAGE_UP);
        sepeteEkle.click();

        // 6- Sepetime git'e tiklayin
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        // 7- Alisverisi tamamlayin'a tikla
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();

    }





}
