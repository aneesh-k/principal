package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AboutTheAppP2 {

    private WebDriver driver;

    public AboutTheAppP2(WebDriver driver){

        this.driver = driver;
    }

    public void setTotalAmount(String amount){
        driver.findElement(By.id("faceAmount")).sendKeys(amount);
    }

    public void isNewYork(boolean val){
        if(val){
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div/div/div[1]/label")).click();
        }else{
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div/div/div[2]/label")).click();
        }
    }

    public void contractSigned(String state){
        Select stateDd = new Select(driver.findElement(By.id("writtenStateLife")));
        stateDd.selectByVisibleText(state);
    }

    public void ClickNext(){
        driver.findElement(By.id("next")).click();
    }

    public void acceleratedUnderwriting(){
        driver.findElement(By.id("acceleratedUnderwriting")).click();
    }

    public void useTraditionalUnderwriting(){
        driver.findElement(By.id("traditionalUnderwriting")).click();
    }

    public void selectParamedVendor(String paramedVendor){
        Select vendDD = new Select(driver.findElement(By.id("paramedVendor")));
        vendDD.selectByVisibleText(paramedVendor);
    }

    public void checkDontNeed(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[2]/div/div/label")).click();
    }

    public AboutTheInsuredP3 pageNext(){
        driver.findElement(By.id("next")).click();
        return new AboutTheInsuredP3(driver);
    }
}
