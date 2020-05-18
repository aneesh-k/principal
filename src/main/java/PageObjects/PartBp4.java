package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartBp4 {

    private WebDriver driver;

    public PartBp4(WebDriver driver){

        this.driver = driver;
    }

    public void clickPhone(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/div/div/div[2]/label")).click();
    }

    public void Submit(){
        driver.findElement(By.id("submit")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("newRequest")));
    }
}
