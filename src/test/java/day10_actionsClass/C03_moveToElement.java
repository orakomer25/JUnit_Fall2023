package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_moveToElement extends TestBase {
    @Test
    public void test01() {

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        WebElement accountLists= driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountLists).perform();
        //3- “Create a list” butonuna basin
        WebElement creatAList= driver.findElement(By.xpath("//*[text()=\"Create a List\"]"));
        actions.click(creatAList).perform();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualyourLists= driver.findElement(By.xpath("//*[@role=\"heading\"]")).getText();
        String expectedYazi="Your Lists";
        Assert.assertEquals(expectedYazi,actualyourLists);

    }
}
