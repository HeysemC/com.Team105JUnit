package day07_dropdwon_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(29));


    }

    @AfterClass
    public static void teardown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement actualSayfaYazisiElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        Thread.sleep(3000);


        //- Text Box’a “Merhaba Dunya!” yazin.

        //normal locate yapip yazdirmayi denedigimizde NoSuchElementException veri
        //elementi bulamadi
        //kontrol ederken istedigimiz webelement'in bir iframe icinde oldugunu gorduk
        //bu durumda onca ı iframe switchto yapmaliyiz.

        WebElement iframeWebElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframeWebElementi);

        WebElement yaziKutuElementi=driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);


        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        //Iframe'in icine girdikten sonra,oradan cik denilinceye kadar
        //driver iframe'n icinde kalir
        //eger disina cikmak istersek

       // driver.switchTo().parentFrame();//bulundugu iframe'den bir ust html sayfasina gecer
                                        //bu daha cok ic ice iframe'ler oldugunda tercih edilir
        driver.switchTo().defaultContent();//anasayfaya gecer

        WebElement elementalSeleniumLinkElementi= driver.findElement(By.xpath("//div[text()='Powered by ']"));
        Assert.assertTrue(elementalSeleniumLinkElementi.isDisplayed());
        System.out.println(elementalSeleniumLinkElementi.getText());

        /*
        ChromeDriver was started successfully.
        Powered by Elemental Selenium
         */    }

}
