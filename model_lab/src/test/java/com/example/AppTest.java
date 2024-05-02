package com.example;

import java.time.Duration;

import javax.swing.Action;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    Logger logger=Logger.getLogger(getClass());
    /**
     * 
     * Rigorous Test :-)
     */

    // @Test
    // public void t1()
    // {
    //     PropertyConfigurator.configure("C:\\Users\\Anitha\\Desktop\\log4j2.properties");
    // }
    @BeforeMethod
    public void fun(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.puriholidayresort.com/");
        driver.manage().window().maximize();
    }

    // @Test
    // public void test1(){
    //     driver.findElement(By.xpath("//*[@id=\"myModal_home\"]/div/div/div[1]/button")).click();
    //     driver.findElement(By.xpath("//*[@id=\"arr_datepicker\"]")).click();
    //    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
    //    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();
    //    driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/form/div[2]/button")).click();

    //     String res=driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div[3]/div/div/div[1]/div")).getText();

    //     if(res.contains("Property Information")){
    //        logger.info("success");
    //        driver.quit();
    //     }
    //     else
    //     logger.info("failure");
    // }

    @Test
    public void test2(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"myModal_home\"]/div/div/div[1]/button")).click();
        driver.manage().window().maximize();
        WebElement hov=driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/a"));
        Actions ac=new Actions(driver);
        ac.moveToElement(hov);
        ac.build().perform();
        driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[5]/div/section/div/h3[2]")).click();
        String res=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[5]/div/section/div/p[2]")).getText();
        if(res.contains("Price")){
            driver.close();
        }

    }
    
}
