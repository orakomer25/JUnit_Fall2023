package day05_JUnitFramework;


import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Ignore;
import org.junit.Test;

public class C02_TestNotasyonu {
    @Test
    public void amazonTets(){
        System.out.println("amazon testi çalıştı");
    }
    @Test @Ignore
    public void youtubeTest(){
        System.out.println("youtube testi çalıştı");
    }
    @Test
    public void wiseTest(){
        System.out.println("wise  testi çalıştı");
    }
    @Test
    public void test04(){
        //verilen iki sayıdan sayı 1 in daha büyük oldugunu test edin
        int sayi1=10;
        int sayi2=50;
        if (sayi1>sayi2){
            System.out.println("sayi karşılaştırma testi PASSED");
        }else {
            System.out.println("sayi karşılastırma testi FAILD");
            throw new IllegalArgumentException();
        }
    }


}
