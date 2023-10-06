package day11_file_testleri_Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_ExplicitWait {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()=\"Remove\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement itsGoneElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[text()=\"It's gone!\"]"))));
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        driver.close();
    }
}
