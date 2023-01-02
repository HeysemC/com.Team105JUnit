package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {


    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement beklenecekElement=driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(beklenecekElement).perform();
        ReusableMethods.bekle(3);

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListElement= driver.findElement(By.xpath("//li[@id='my-lists-tab']"));
        Assert.assertTrue(yourListElement.isDisplayed());



    }


}
