package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AboutTheInsuredP3 {

    private WebDriver driver;

    public AboutTheInsuredP3(WebDriver driver){

        this.driver = driver;
    }

    public void firstName(String firstName){
        driver.findElement(By.id("insuredFirstName")).sendKeys(firstName);
    }

    public void lastName(String lastName){
        driver.findElement(By.id("insuredLastName")).sendKeys(lastName);
    }

    public void selectGender(boolean isMale){
        if(isMale){
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/div/div/div[1]/label")).click();
        }else {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/div/div/div[2]/label")).click();
        }
    }

    public void clickNext(){
        driver.findElement(By.id("next")).click();
    }

    public void emailId(String email){
        driver.findElement(By.id("insuredEmail")).sendKeys(email);
    }

    public void phone(String ph){
        driver.findElement(By.id("insuredPhone")).sendKeys(ph);
    }

    public void address(String address){
        driver.findElement(By.id("insuredAddress")).sendKeys(address);
    }

    public void city(String city){
        driver.findElement(By.id("insuredCity")).sendKeys(city);
    }

    public void selectState(String state){
        Select stateDd = new Select(driver.findElement(By.id("insuredState")));
        stateDd.selectByVisibleText(state);
    }

    public void zip(String zip){
        driver.findElement(By.id("insuredZip")).sendKeys(zip);
    }

    public FieldOfficeContactP4 pageNext(){
        driver.findElement(By.id("next")).click();
        return new FieldOfficeContactP4(driver);
    }


}
