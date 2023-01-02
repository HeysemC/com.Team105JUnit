package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {

    /*
    Selenium 4 ile windows konusunda yeni birr ozellik geldi

    istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
    Bu durumda driver'imiz da otomatik olarak yeni sayfaya gecmis olur

    Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa
    o sayfada iken o sayfanin window handle degeri alinip kaydedilir
    ve o sayfaya gecmek istenildiginde
    driver.switchTo().window(ilkSayfaHandleDegeri);
    kodu ile o sayfaya gecis yapilir.

     */


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(26));

    }
    @After
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        //Testin ilerleyen asamalarinda yeniden amazon sayfasina donmek gerekiyorsa
        //amazon sayfasindaki iken bu window'un handle degerini alip kaydetmeliyiz
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        //yeni bir tab'da wisequarter.com'a gidin ve gittigimizi test edin
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl=driver.getCurrentUrl();
        String expectedKelime="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

        //wisequarter testini yaptiktan sonra
        //yeniden amazon'un acik oldugu TAB'a geçin ve amazon anasayfanın
        //açık oldugunu test edin.

        driver.switchTo().window(ilkSayfaHandleDegeri);
        String actualUrl1=driver.getCurrentUrl();
        String expectedKelime1="amazon";
        Assert.assertTrue(actualUrl1.contains(expectedKelime1));
        Thread.sleep(3000);




    }

}
