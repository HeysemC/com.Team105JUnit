package testPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class KeyboardActions2 extends TestBase {


@Test
    public void test01(){


    //2- https://html.com/tags/iframe/ sayfasina gidelim
    driver.get("https://html.com/tags/iframe/");

    //3- video’yu gorecek kadar asagi inin
    WebElement expectedSayfa=driver.findElement(By.xpath("(//a[@rel='home'])[1]"));
    expectedSayfa.sendKeys(Keys.PAGE_DOWN);
    expectedSayfa.sendKeys(Keys.PAGE_DOWN);

    //4- videoyu izlemek icin Play tusuna basin
    WebElement iframeKismi=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
    driver.switchTo().frame(iframeKismi);
    ReusableMethods.bekle(2);
    WebElement playButton=driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
    Actions actions=new Actions(driver);
    playButton.click();

    //5- videoyu calistirdiginizi test edin
    WebElement videoOynaticiAktiv= driver.findElement(By.xpath("//button[@data-title-no-tooltip='Duraklat']"));
    Assert.assertTrue(videoOynaticiAktiv.isDisplayed());
    System.out.println(videoOynaticiAktiv+"test basarili");
    //[[ChromeDriver: chrome on WINDOWS (db161442e78b78691c1429890383f307)]
    // -> xpath: //button[@data-title-no-tooltip='Duraklat']]test basarili

}




}
