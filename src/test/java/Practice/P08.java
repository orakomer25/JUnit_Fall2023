package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class P08 extends TestBase {
    @Test
    public void test01() {
        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");
        //2 ) Nurse  3 farkli relative locator ile locate edin
        WebElement doctorElement=driver.findElement(By.xpath("//*[@id=\"dr_thumb\"]"));
        WebElement nurseElement1= driver.findElement(RelativeLocator.with(By.id("nurs_thumb")).below(doctorElement));


        WebElement policeManElement=driver.findElement(By.xpath("//*[@id=\"pol_thumb\"]"));

        WebElement nurseElement2=driver.findElement(RelativeLocator.with(By.id("nurs_thumb")).toLeftOf(policeManElement));

        //3 ) Relative locator'larin dogru calistigini test edin
        Assert.assertEquals(nurseElement1.getText(),nurseElement2.getText());

    }
}
