package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_cookies extends TestBase {
    @Test
    public void test01() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
       Set<Cookie> cookieSet=driver.manage().getCookies();
       int siraNo=1;
        for (Cookie each:cookieSet
             ) {
            System.out.println(siraNo+" - "+each);
            siraNo++;

        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCSayisi=5;
        int actualCSayisi=cookieSet.size();
        Assert.assertTrue(actualCSayisi>expectedMinCSayisi);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieValue="USD";
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        siraNo=1;
        System.out.println("*************************************");
        for (Cookie each:cookieSet
        ) {
            System.out.println(siraNo+" - "+each);
            siraNo++;

        }
        boolean yeniCookieEklendiMi=false;
        for (Cookie each:cookieSet
             ) {if (each.getName().equals("en sevdigim cookie")){
                 yeniCookieEklendiMi=true;
        }

        }
        Assert.assertTrue(yeniCookieEklendiMi);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet=driver.manage().getCookies();
        boolean CookieSilindiMi=true;
        for (Cookie each:cookieSet
        )
        {
            if (each.getName().equals("skin")){
                System.out.println(each.getName());
            CookieSilindiMi=false;
        }

        }
        Assert.assertTrue(CookieSilindiMi);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        int expectedSize=0;

        int actualSize=cookieSet.size();

        Assert.assertEquals(expectedSize,actualSize);
    }
}
