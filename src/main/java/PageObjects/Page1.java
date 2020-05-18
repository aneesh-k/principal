package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Page1 {


    private WebDriver driver;

    public Page1(WebDriver driver){
        this.driver = driver;
    }

    public void SelectLife(){
        System.out.println("Navigated to URL");
        Select productDd = new Select(driver.findElement(By.id("product")));
        productDd.selectByVisibleText("Life");
        System.out.println("Selected Life");
    }

    public void dropTicketNo(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div[2]/div/div[2]/label")).click();
    }

    public void adjustmentNo(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[4]/div[2]/div/div[2]/label")).click();
    }

    public void setDOB(String dob){
        driver.findElement(By.id("dateOfBirth")).sendKeys(dob);
    }

    public AboutTheAppP2 ClickNext(){
        driver.findElement(By.id("next")).click();
        return new AboutTheAppP2(driver);
    }




}
