package testPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TestHomeworkAmazon extends TestBase {


    @Test
    public void test01(){

        //1- amazon gidin
        driver.get("https://www.amazon.com/");

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement expectedAllMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(expectedAllMenu).perform();
        ReusableMethods.bekle(2);
        String menuText=expectedAllMenu.getText();



        //3- dropdown menude 40 eleman olduğunu doğrulayın
        List<String> toplamMenu=new ArrayList<>();
        int sayac=0;
        for (int i = 0; i < menuText.length(); i++) {
            menuText.equalsIgnoreCase(" ");
            toplamMenu.add(String.valueOf(i));

            sayac++;

        }


        ReusableMethods.bekle(2);
        System.out.println(sayac);








    }


}
