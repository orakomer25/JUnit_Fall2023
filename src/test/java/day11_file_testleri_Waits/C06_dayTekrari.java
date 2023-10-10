package day11_file_testleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C06_dayTekrari extends TestBase {
    @Test
    public void test01() {
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //2. Img.PNG dosyasını indirelim    //*[text()="Image.PNG"]
        driver.findElement(By.xpath("//*[text()=\"Image.PNG\"]")).click();
        //bekleme koyalım.
        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim
       String dosyaYolu="C:\\Users\\orako\\Downloads\\Image.PNG";
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //4.Dosya yolunu dinamik hale getirelim
        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\Image.PNG";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }

    @Test
    public void test02() {
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim     id="file-upload"
        //3.text.txt  dosyasını secelim.    "\\src\\test\\java\\day11_file_testleri_Waits\\text.txt"
        //C:\Users\orako\IdeaProjects\Team120_JUnit_Fall2023\src\test\java\day11_file_testleri_Waits\text.txt
        WebElement uploadButtonElementi = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.dir") + "\\src\\test\\java\\day11_file_testleri_Waits\\text.txt";
        uploadButtonElementi.sendKeys(dinamikDosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

    }

    @Test
    public void test03() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\orako\IdeaProjects\Team120_JUnit_Fall2023
        //proje içindeki text.txt dosyasının var oldugunu test edelim
        String dinamikTextDosyaYolu=System.getProperty("user.dir")+"\\src\\test\\java\\day11_file_testleri_Waits\\text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));
    }


}
