package practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {



    /*

    ..........Exercise1............

    BeforeClass ile driver'i olusturun ve class icinde static yapin

    Maximize edin ve 10 sn bekletin

    http://www.google.com adresine gidin

    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin

    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin

    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin

    AfterClass ile kapatin

     */

    static WebDriver driver;


    @AfterClass
    public static void tearDown(){

        // AfterClass ile kapatin
        driver.close();
    }




   // BeforeClass ile driver'i olusturun ve class icinde static yapin
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        // Maximize edin ve 10 sn bekletin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

@Before
public void beforeTest(){

    // http://www.google.com adresine gidin
    driver.get("http://www.google.com");
}




    @Test
    public void test01(){

        //driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click();


        // arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The Lord of the Rings");


        WebElement sonuc1=driver.findElement(By.id("result-stats"));
        System.out.println(sonuc1.getText());

    }






    // arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test2(){


        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart");
        WebElement sonuc2=driver.findElement(By.id("result-stats"));
        System.out.println(sonuc2.getText());


    }



   // arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
   @Test
   public void test3(){


       driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();

       driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter");
       WebElement sonuc3=driver.findElement(By.id("result-stats"));
       System.out.println(sonuc3.getText());


   }


/*
..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin.

static WebDriver driver;
    @AfterClass
    public static void tearDown(){
        //  AfterClass ile kapatin
        driver.close();
    }
    //  BeforeClass ile driver'i olusturun ve class icinde static yapin
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //  Maximize edin ve 10 sn bekletin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before
    public void beforeTest(){
        //  http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click();
        //  arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The Lord of the Rings"+ Keys.ENTER);
        WebElement sonuc1 = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc1.getText());
    }
    @Test
    public void test02(){
        //  arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart"+ Keys.ENTER);
        WebElement sonuc2 = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc2.getText());
    }
    @Test
    public void test03(){
        //  arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter"+ Keys.ENTER);
        WebElement sonuc3 = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc3.getText());
 */




}
