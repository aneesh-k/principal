package ScriptPackage;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class InitScript {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","src\\main\\java\\Resources\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://18.233.10.166:4444/wd/hub"), options);
        //driver = new RemoteWebDriver(new URL("http://52.90.7.52:4444/wd/hub"), options);
        driver.get("https://insurance.advisors.principal.com/");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("product")));

    }

    @Test
    @Parameters({"dob", "totalAmount", "isNewYork", "signedState",
    "firstName", "lastName", "gender", "emailId", "phoneNumber", "address", "city", "state", "zip",
    "fieldOfficeName", "fieldOfficeEmail", "fieldOfficePhone", "submit", "accelerated", "paramed",
            "completionMethod"})
    public  void metho1(String dob, String totalAmount, String isNewYork, String contractSignedState,
                        String firstName, String lastName, String gender, String emailId, String phoneNumber,
                        String address, String city, String state, String zip, String fieldOfficeName,
                        String fieldOfficeEmail, String fieldOfficePhone, String submit,
                        String accelerated, String paramed, String completionMethod){
        try{
            //Init Page
            Page1 page1 = new Page1(driver);
            page1.SelectLife();
            System.out.println("Selected Life");
            page1.dropTicketNo();
            System.out.println("Selected No");
            page1.adjustmentNo();
            System.out.println("Selected No");
            page1.setDOB(dob);
            System.out.println("Date Entered: "+dob);
            AboutTheAppP2 p2 = page1.ClickNext();
            System.out.println("Clicked Next, moved to p2");

            //AboutTheApp - page 2
            p2.setTotalAmount(totalAmount);
            System.out.println("Entered Amount: "+ totalAmount);
            if(isNewYork.toLowerCase().equalsIgnoreCase("false")){
                p2.isNewYork(false);
                System.out.println(" No Selected for New York");
                p2.contractSigned(contractSignedState);
                System.out.println("selected state: "+ contractSignedState);
            }else{
                p2.isNewYork(true);
                System.out.println("Yes : NewYork selected ");
            }

            p2.ClickNext();
            System.out.println("clicked on next");
            if(accelerated.equalsIgnoreCase("true")){
                p2.acceleratedUnderwriting();
                System.out.println("selected accelerated underwriting");
            }else{
                p2.useTraditionalUnderwriting();
                System.out.println("selected traditional underwriting");
            }

            if(paramed.equalsIgnoreCase("none")){
                p2.checkDontNeed();
                System.out.println("clicked check box for dont need");
            }else{
                p2.selectParamedVendor(paramed);
                System.out.println(paramed + " value selected");
            }

            AboutTheInsuredP3 p3 = p2.pageNext();
            System.out.println("Clicked next, moved to p3");

            //About the Insured P3
            p3.firstName(firstName);
            System.out.println("First name entered: "+firstName);
            p3.lastName(lastName);
            System.out.println("last name entered: "+lastName);
            if(gender.toLowerCase().equalsIgnoreCase("male")){
                p3.selectGender(true);
                System.out.println("Gender selected : Male");
            }else{
                p3.selectGender(false);
                System.out.println("Gender selected : Female");
            }

            p3.clickNext();
            p3.emailId(emailId);
            System.out.println("email entered: "+emailId);
            p3.phone(phoneNumber);
            System.out.println("phone number entered :"+phoneNumber);
            p3.clickNext();
            p3.address(address);
            System.out.println("address Entered :" + address);
            p3.city(city);
            System.out.println("city entered: "+city);
            p3.selectState(state);
            System.out.println("state selected :"+state);
            p3.zip(zip);
            System.out.println("ZIP entered :"+zip);
            FieldOfficeContactP4 p4 = p3.pageNext();

            p4.fieldOfficeName(fieldOfficeName);
            System.out.println("Field Office Name : "+fieldOfficeName);
            p4.FOEmail(fieldOfficeEmail);
            System.out.println("Field Office Email :"+fieldOfficeEmail);
            p4.phone(fieldOfficePhone);
            System.out.println("Field Office Phone: "+fieldOfficePhone);
            PartBp4 p5 = p4.clickNext();
            if(completionMethod.equalsIgnoreCase("phone")){
                p5.clickPhone();
            }
            if(submit.equalsIgnoreCase("true")){
                p5.Submit();
            }
            System.out.println("Success B\"H");
        }catch (Exception e){
            System.out.println("Error running the script. Data not Entered");
        }





    }

    @AfterClass
    public void Teardown(){
       //driver.close();
    }
}
