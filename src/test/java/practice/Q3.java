package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q3 extends TestBase {


    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
    */
    @Test
    public void test01(){
        driver.get("http://automationexercise.com");
        WebElement automationExerciseBasligi = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        boolean baslikGorunurMu = automationExerciseBasligi.isDisplayed();
        assertTrue(baslikGorunurMu);
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
        WebElement actContactUsPageBaslik = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        assertTrue(actContactUsPageBaslik.isDisplayed());
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions = new Actions(driver);
        actions.
                click(firstNameTextBox).
                sendKeys("Bulent").
                sendKeys(Keys.TAB).
                sendKeys("bulent@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Otomasyon").
                sendKeys(Keys.TAB).
                sendKeys("Hello New Year").
                perform();
        WebElement dosyaSecButonu =driver.findElement(By.xpath("//input[@name='upload_file']"));
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\deneme.docx";
        dosyaSecButonu.sendKeys(dosyaYolu);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.switchTo().alert().accept();
        WebElement succesfullYazisi = driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]"));
        assertTrue(succesfullYazisi.isDisplayed());
        driver.findElement(By.xpath("(//a[text()=' Home'])[1]")).click();
        driver.findElement(By.id("dismiss-button")).click();
        assertTrue(baslikGorunurMu);
    }
}
