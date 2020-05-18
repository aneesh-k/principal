package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Main {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","src\\main\\java\\Resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://insurance.advisors.principal.com/");

        //Page - 1
        Thread.sleep(4000);
        System.out.println("Navigated to URL");
        Select productDd = new Select(driver.findElement(By.id("product")));
        productDd.selectByVisibleText("Life");
        System.out.println("Selected Life");

        //first no
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div[2]/div/div[2]/label")).click();

        //second no
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[4]/div[2]/div/div[2]/label")).click();

        //DOB
        driver.findElement(By.id("dateOfBirth")).sendKeys("02/02/2020"); // var -DOB Value
        driver.findElement(By.id("next")).click();

        //page-2
        Thread.sleep(1000);
        //totalAmount
        driver.findElement(By.id("faceAmount")).sendKeys("500000"); // var - totAmou

        //isNewYork
        //No
        driver.findElement(By.id("//*[@id=\"root\"]/div/div/form/div[3]/div/div/div[2]/label")).click();
        //yes
        driver.findElement(By.id("//*[@id=\"root\"]/div/div/form/div[3]/div/div/div[1]/label")).click();


    }


}
