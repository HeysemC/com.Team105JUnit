package day07_dropdwon_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {

    WebDriver driver;

    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(26));
        driver.manage().window().maximize();



    }


    @After
    public void teardown() throws InterruptedException {

        Thread.sleep(5000);
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {

        //ilgili ayarlari yapip
        //amazon anasayfasina gidin
        //arama kutusu yanindaki dropdwon menuden book secip
        //arama kutusuna java yazdirip aramayi yapin
        //title'in java icerdigini test edin

        driver.get("https://www.amazon.com");

        //Dropdown menuden istedigimiz option'i secebilmek icin
        // oncelikle select class'dan bir object olusturmaliyiz
        //ancak select objesi olusturmak icin Select class'nin constructor'i
        //handle edecegimiz webelement'i istediginden
        //1-select objesi olusturmadan once dropdown webelementini locate etmeliyiz

        WebElement dropdownWebElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Select class'indan obje olusturmak
        Select select=new Select(dropdownWebElementi);

        //3-select.selectByValue("search-alias=stripbooks-intl-ship");
        //select..selectByIndex(5);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        String expectedKelime="Java";
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKelime));

        /*
        Locate ettigimiz elementi bulamazsa NoSuchElementException
        sayfa yenilendigi icin var olan bir elementi kullanamazsa
        StaleElementException verir
        bu durumda locate ve secme islerini yeniden yaparsak kodumuz calisir
         */

        dropdownWebElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownWebElementi);
        select.selectByVisibleText("Books");

        //dropdown menu'den book seceneginin secildigini test edin
        String actualSecilenOption=select.getFirstSelectedOption().getText();
        String expectedSecilecekOption="Books";
        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);

        //Dropdown menudeki secenek sayisinin 28 oldugunu test edin
        List<WebElement> optionsWebElementListesi = select.getOptions();

        int actualOptionSayisi=optionsWebElementListesi.size();
        int expectedOpsiyonSayisi=28;

        Assert.assertEquals(expectedOpsiyonSayisi,actualOptionSayisi);


        Thread.sleep(5000);

    }


}
