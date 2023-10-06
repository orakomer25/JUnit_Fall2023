package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01_dropdownMenu extends TestBase {
    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropdown);

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionList = select.getOptions();
        System.out.println("Tüm Opsiyonlar");
        for (WebElement each:optionList
             ) {
            System.out.println(each.getText());

        }
        // 5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedBoyut=4;
        int actualBoyut= optionList.size();
        Assert.assertEquals("Dropdown menu boyutu 4 değil",expectedBoyut,actualBoyut);
    }
}
