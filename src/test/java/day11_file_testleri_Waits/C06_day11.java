package day11_file_testleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_day11 extends TestBase {
    //test01
    //1. https://the-internet.herokuapp.com/download adresine gidelim.
    //2. Img.PNG dosyasını indirelim    //*[text()="Image.PNG"]
    //3. Dosyanın başarıyla indirilip indirilmediğini test edelim  C:\\Users\\orako\\Downloads\\Image.PNG
    //String dosyaYolu="C:\\Users\\orako\\Downloads\\Image.PNG";
    //4.Dosya yolunu dinamik hale getirelim

    @Test
    public void test01() {
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(3);
        //2. Img.PNG dosyasını indirmesi için tıklayalım    //*[text()="Image.PNG"]
        driver.findElement(By.xpath("//*[text()=\"Image.PNG\"]")).click();
        bekle(3);
        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim  "C:\\Users\\orako\\Downloads\\Image.PNG"
        String dosyaYolu = "C:\\Users\\orako\\Downloads\\Image.PNG";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //4.Dosya yolunu dinamik hale getirelim
        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\Image.PNG";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        bekle(3);

    }


    //test02
    //1.https://the-internet.herokuapp.com/upload adresine gidelim
    //2.chooseFile butonuna basalim     id="file-upload"
    //3.text.txt  dosyasını secelim.    "\\src\\test\\java\\day11_file_testleri_Waits\\text.txt"
    //C:\Users\orako\IdeaProjects\Team120_JUnit_Fall2023\src\test\java\day11_file_testleri_Waits\text.txt
    //uploadButton id=file-upload

    //Upload butonuna basalim.

    //“File Uploaded!” textinin goruntulendigini test edelim.   tagname=h3

    @Test
    public void test02() {

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        bekle(3);
        //2.chooseFile butonuna basalim ve dosya yolunu olusturalım    //*[@id="file-upload"]
        WebElement chooseFileButton = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
        String dosyaYolu1 = "C:\\Users\\orako\\Downloads\\Image.PNG";
        String dinamikDosyaYolu1=System.getProperty("user.home")+"\\Downloads\\Image.PNG";
        chooseFileButton.sendKeys(dinamikDosyaYolu1);
        bekle(3);
        //Upload butonuna basalim.   //*[@id="file-submit"]
        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();
        bekle(3);

        //“File Uploaded!” textinin goruntulendigini test edelim.   tagname=h3
        WebElement fileUploaded=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploaded.isDisplayed());
        bekle(3);

    }
    @Test
    public void test03() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\orako\IdeaProjects\Team120_JUnit_Fall2023
        //proje içindeki text.txt dosyasının var oldugunu test edelim
        String dinamikTextDosyaYolu=System.getProperty("user.dir")+"\\src\\test\\java\\day11_file_testleri_Waits\\text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));
    }
}
