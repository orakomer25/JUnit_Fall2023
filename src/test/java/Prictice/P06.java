package Prictice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class P06 extends TestBase {
    @Test
    public void name() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String actualTitle= driver.getTitle();
        String expectedTitle="Automation Exercise";
        Assert.assertEquals(expectedTitle,actualTitle);
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupYaziElementi= driver.findElement(By.xpath("//*[text()=\"New User Signup!\"]"));
        Assert.assertTrue(newUserSignupYaziElementi.isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa=\"signup-name\"]")).sendKeys("omer25555");
        driver.findElement(By.xpath("//*[@data-qa=\"signup-email\"]")).sendKeys("omer25555@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa=\"signup-button\"]")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationYaziElementi= driver.findElement(By.xpath("//*[text()=\"Enter Account Information\"]"));
        Assert.assertTrue(enterAccountInformationYaziElementi.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@name=\"title\"]")).click();
        driver.findElement(By.id("password")).sendKeys("omer25.");
        driver.findElement(By.id("days")).sendKeys("20");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("1986");

        //10. Select checkbox 'Sign up for our newsletter!'

        //11. Select checkbox 'Receive special offers from our partners!'


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@data-qa=\"first_name\"]")).sendKeys("omer");
        driver.findElement(By.xpath("//*[@data-qa=\"last_name\"]")).sendKeys("orak");
        driver.findElement(By.xpath("//*[@data-qa=\"address\"]")).sendKeys("niğde");
        WebElement dropdown=driver.findElement(By.xpath("//*[@data-qa=\"country\"]"));
        Select select=new Select(dropdown);
        select.selectByValue("Canada");
        driver.findElement(By.xpath("//*[@data-qa='state']")).sendKeys("Non USA");
        driver.findElement(By.xpath("//*[@data-qa='city']")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@data-qa='zipcode']")).sendKeys("34647");
        driver.findElement(By.xpath("//*[@data-qa='mobile_number']")).sendKeys("903334445566");

        bekle(15);
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();


        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedYaziElementi=driver.findElement(By.xpath("//*[text()=\"Account Created!\"]"));
        Assert.assertTrue(accountCreatedYaziElementi.isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInAsYaziElementi=driver.findElement(By.xpath("//*[@class=\"fa fa-user\"]"));
        Assert.assertTrue(loggedInAsYaziElementi.isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=\" Delete Account\"]")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleteYaziElementi=driver.findElement(By.xpath("//*[text()=\"Account Deleted!\"]"));
        Assert.assertTrue(accountDeleteYaziElementi.isDisplayed());
        driver.findElement(By.xpath("//*[@data-qa=\"continue-button\"]")).click();
    }
}
