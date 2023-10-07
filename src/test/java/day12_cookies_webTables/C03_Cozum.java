package day12_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_Cozum extends TestBase {
    @Test
    public void test01() {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersElements=driver.findElements(By.xpath("//*[@class=\"rt-thead -header\"]"));
        for (WebElement each:headersElements
             ) {
            System.out.println(each.getText());
            
        }
        // 3. 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@class=\"rt-th rt-resizable-header -cursor-pointer\"][3]")).getText());

        // 4. Tablodaki tum datalari yazdirin
        System.out.println("**********4.MADDE TABLO************");
        System.out.println(driver.findElement(By.xpath("//*[@class=\"rt-tbody\"]")).getText());



        String dataXPath="//*[@class=\"rt-tr-group\"][1]//*[@class=\"rt-td\"][1]";


        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> tableElements=driver.findElements(By.xpath("//*[@class=\"rt-td\"]"));
        int sayac=0;
        for (WebElement each:tableElements
             ) {
            if (!each.getText().isBlank()){
                sayac++;

            }
        }
        System.out.println("Boş Olmayan Cell Sayisi :"+sayac);
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirElementsListesi=driver.findElements(By.xpath("//*[@class=\"rt-tr-group\"]"));
        System.out.println("Tablodaki Satir Sayisi :"+satirElementsListesi.size());
        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisiListesi=driver.findElements(By.xpath("(//*[@class=\"rt-tr-group\"])[1]//*[@class=\"rt-td\"]"));
        System.out.println("Tablodaki sutun sayisi :"+sutunSayisiListesi.size());

        // 8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuKolonElements=
                driver.findElements(By.xpath("//*[@class=\"rt-tr-group\"]//*[@class=\"rt-td\"][3]"));
        System.out.println("===== 3.kolon=====");
        for (WebElement each:ucuncuKolonElements
             ) {
            System.out.println(each.getText());

        }
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        String ilkKisim="(//div[@class=\"rt-tr-group\"])[";
        String ikinciKisim="]//*[@class=\"rt-td\"][1]";
        String ucuncuKisim="]//*[@class=\"rt-td\"][5]";
        String expectedIsim="Kierra";

        for (int i = 1; i <=7 ; i++) {
            String dinamikIsim=driver.findElement(By.xpath(ilkKisim+i+ikinciKisim)).getText();
            String dinamikMaas=ilkKisim+i+ucuncuKisim;
            if (dinamikIsim.equals(expectedIsim)){
                System.out.println(expectedIsim+" nın maası:"+driver.findElement(By.xpath(dinamikMaas)).getText());
            }

        }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }
}
