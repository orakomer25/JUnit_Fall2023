package day11_file_testleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileDownload extends TestBase {
    @Test
    public void test01() {
        //C:\Users\orako\OneDrive\Masaüstü/logo.jpg
       //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(2);
        //3. logo.jpg dosyasını indirelim
        driver.findElement(By.xpath("//*[text()=\"logo.jpg\"]")).click();
        bekle(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\orako\\Downloads\\logo.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        bekle(2);
    }
}
