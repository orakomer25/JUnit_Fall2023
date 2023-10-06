package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C03_dropdownMenu extends TestBase_BeforeClass {
    WebElement dropdownMenu;
    Select select;

    @Before
    public void amazonaGit() {
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        dropdownMenu = driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]"));
        select=new Select(dropdownMenu);
    }

    @Test
    public void Test01() {
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        List<WebElement> ddm = select.getOptions();
        int actualKategoriSayisi= ddm.size();
        int expectedKategoriSayisi=45;
        Assert.assertEquals("Kategori dropdown menusunde 45 opsiyon yok",expectedKategoriSayisi,actualKategoriSayisi);


    }

    @Test
    public void Test02() {
        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        WebElement resultElement=driver.findElement(By.xpath("(//div[@class=\"sg-col-inner\"])[1]"));
        String resultText= resultElement.getText();
        System.out.println(resultText);
        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        Assert.assertTrue(resultText.contains(expectedIcerik));

    }

}