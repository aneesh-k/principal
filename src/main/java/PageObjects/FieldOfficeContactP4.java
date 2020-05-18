package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FieldOfficeContactP4 {

    private WebDriver driver;

    public FieldOfficeContactP4(WebDriver driver){
        this.driver = driver;
    }

    public void fieldOfficeName(String name){
        driver.findElement(By.id("contactName")).sendKeys(name);
    }

    public void FOEmail(String email){
        driver.findElement(By.id("contactEmail")).sendKeys(email);
    }

    public void phone(String phone){
        driver.findElement(By.id("contactPhone")).sendKeys(phone);
    }

    public PartBp4 clickNext(){
        driver.findElement(By.id("next")).click();
        return new PartBp4(driver);
    }
}
