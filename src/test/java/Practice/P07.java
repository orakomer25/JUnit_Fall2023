package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P07 extends TestBase {
    @Test
    public void test01() {
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();
        //3. Login alanine  “username” yazdirin
        WebElement login= driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        login.sendKeys("username");
        //4. Password alanina “password” yazdirin
        WebElement password= driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=\"Online Banking\"])[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazi
        WebElement amountElementi=driver.findElement(By.xpath("//*[@id=\"sp_amount\"]"));
        amountElementi.sendKeys("400");
        //9. tarih kismina “2020-09-10” yazdirin
        WebElement dateElementi=driver.findElement(By.xpath("//*[@id=\"sp_date\"]"));
        dateElementi.sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement thePaymentyaziElementi=driver.findElement(By.xpath("//*[text()=\"The payment was successfully submitted.\"]"));

        Assert.assertTrue(thePaymentyaziElementi.isDisplayed());
    }
}
