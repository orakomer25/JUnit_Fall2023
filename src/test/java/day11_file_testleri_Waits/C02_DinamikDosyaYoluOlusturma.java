package day11_file_testleri_Waits;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma {
    @Test
    public void test01() {
        //C:\Users\orako\OneDrive\Masaüstü\logo.jpg
           /*
            Testlerimizin farkli bilgisayarlarda da calismasi gerekiyorsa
            file testleri icin gerekli olan DOSYA YOLU dinamik yapilmalidir
            Java'da dosya yolunu kodun calistigi bilgisayardan
            otomatik olarak almak icin 2 secenek vardir
            System.getProperty("user.home") ===> bilgisayarin ana dosya yolunu verir
            System.getProperty("user.dir")  ===>
         */
        // masaustumuzde bulunan logo.jpg dosyasinin varligini
        // dinamik dosya yolu kullanarak test edelim
        //     /Users/ahmetbulutluoz/Desktop/logo.jpg
        //     "/Users/ahmetbulutluoz" +    "/Desktop/logo.jpg"
        //         Ana dosya yolu        Herkeste ayni olan kisim


        String dinamikDosyaYolu = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\logo.jpg" ;
        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\orako\IdeaProjects\Team120_JUnit_Fall2023
        //C:\Users\orako\IdeaProjects\Team120_JUnit_Fall2023\src\test\java\day11_file_testleri_Waits
        String dinamikTextDosyayolu = System.getProperty("user.dir") +
                "\\src\\test\\java\\day11_file_testleri_Waits";
        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyayolu)));
    }
}
