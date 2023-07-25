
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.http.util.EntityUtils;
import java.io.File;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;


import javax.swing.*;
import java.awt.*;

public class test1 {


    public static void main(String[] args) {

        //  //
        System.setProperty("webdriver.chrome.driver","C:\\Otomasyon_test\\driver\\chromedriver.exe");
        WebDriver driverCalıs = new ChromeDriver();
        ;
        driverCalıs.get("https://demoqa.com/text-box");


        WebElement nameElement = driverCalıs.findElement(By.id("userName"));
        nameElement.click();
        nameElement.sendKeys("reis");

        WebElement mailElement = driverCalıs.findElement(By.id("userEmail"));
        mailElement.click();
        mailElement.sendKeys("alihan3134@gmail.com");

        WebElement adresElement = driverCalıs.findElement(By.id("currentAddress"));
        adresElement.click();
        adresElement.sendKeys("İstanbul");

        WebElement adres2Element = driverCalıs.findElement(By.id("permanentAddress"));
        adres2Element.click();
        adres2Element.sendKeys("Ataşehir");

        WebElement button = driverCalıs.findElement(new By.ByCssSelector("button.btn"));
        button.click();

        WebElement  testname = driverCalıs.findElement(By.xpath("//div/p[@id='name']"));
        String a =testname.getText();
        System.out.println(a);

        driverCalıs.get("https://demoqa.com/checkbox");   // Checkbox ın olduğu safayı açmak için

        WebElement checkbox =driverCalıs.findElement(new By.ByCssSelector("label[for='tree-node-home'] span.rct-checkbox svg ")); // Checkboxu seçiyoruz.
        checkbox.click();  // checkbox tıklama olayı

        checkbox =driverCalıs.findElement(new By.ByCssSelector("label[for='tree-node-home'] span.rct-checkbox svg "));   // Checkbox tekrak seçiyoruz.

        String checkboxKontrol = checkbox.getAttribute("class");  // oluşturduğumuz değişkene seçtiğimiz checkbox un class değerini atıyoruz.
        if (checkboxKontrol.equals("rct-icon rct-icon-check")){
            System.out.println("checked");
        }
        else {
            System.out.println(" no checked");
        }
        // Checkbox ın  true&false değerini karşılaştırıyoruz.

        driverCalıs.get("https://demoqa.com/automation-practice-form");
        WebElement formCheckBox = driverCalıs.findElement(By.id("hobbies-checkbox-1"));

        boolean tıklamaKontrol = formCheckBox.isEnabled(); // tıklama olayı varmı kontrol ediyoruz
        System.out.println(tıklamaKontrol);

        if (tıklamaKontrol){  // tıklama olayı var ise bu koşula gir

            try {
                formCheckBox.click();
                System.out.println("try komutu çalıştı");
            }
            catch (Exception e){
                WebElement labelClick =driverCalıs.findElement(By.cssSelector("label[for=hobbies-checkbox-1]"));
                labelClick.click();
                System.out.println("catch komutu çalıştı");
            }
            // bazen checkbox'a tıklamak istediğimiz zaman yanındaki yazıya tıklamamız gerekir. Bu nedenle try-catch ile iki tıklama metodunu kontrol ederek işlemimizi devam ettirdik.
        }


        driverCalıs.get("https://demoqa.com/buttons");
        WebElement dubleClick =driverCalıs.findElement(By.id("doubleClickBtn"));
        WebElement rightClick =driverCalıs.findElement(By.id("rightClickBtn"));

        Actions action = new Actions(driverCalıs);
        action.doubleClick(dubleClick).perform();
        action.contextClick(rightClick).perform();

        // Action class'ı ile farklı tıklama olayı


        WebElement dinamikclick = driverCalıs.findElement(By.xpath("//div[last()]/button"));
        dinamikclick.click();
        // Dinamik buton olduğu için xpath yolu ile saçiyoruz ve tıklıyoruz.

        driverCalıs.get("https://demoqa.com/dynamic-properties");
        WebElement TextE =driverCalıs.findElement(By.xpath("//div/p"));
        String testText = TextE.getText();
        System.out.println(testText);

        // xpath ile texti alıyor

       // WebElement firstbotn = driverCalıs.findElement(By.id("enableAfter"));
      //  WebDriverWait beklebtn = new WebDriverWait(driverCalıs,5); //  WebDriverWait ile 5 saniye bekletiyoruz.
       // beklebtn.until(ExpectedConditions.elementToBeClickable(firstbotn));      //   Tıklanabilir olduğunu kontrol ediyor
       // firstbotn.click();
        // !!!!!! bir sonraki işlemdem de 5 sn bekleteceğimiz için açıklama yapıyorum !!!!

        WebElement colorDeğisim =driverCalıs.findElement(By.id("colorChange"));
        String ilkrenk = colorDeğisim.getCssValue("color"); // css renk değerini değişkene atıyoruz
        System.out.println(ilkrenk);

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5sn bbekletiyoruz. Bir
        String yenirenk = colorDeğisim.getCssValue("color"); // tekrar rengini yeni renk değişkenine atıyoruz.
        System.out.println(yenirenk);


        // Server Side Istek Atma

        try {
            HttpClient clint = HttpClientBuilder.create().build();      // Clint oluşturuyoruz.
            HttpGet request = new HttpGet("https://demoqa.com/");   // request oluşturup url giriyoruz
            HttpResponse responde = clint.execute(request);             // dönen cevabı tutmak için response oluşturuyoruz
            int statuscode = responde.getStatusLine().getStatusCode();  // status codunu alıyoruz ve yazdırıyoruz.
            System.out.println(statuscode);
        } catch (IOException e){
            e.printStackTrace();
        }
            //  

        driverCalıs.get("https://demoqa.com/upload-download");
        WebElement dwl = driverCalıs.findElement(By.id("downloadButton"));
        dwl.click();  // Dosyayı indirmek için tıklıyoruz.

        String fileName = "sampleFile.jpeg"; // Dosyanın adını buraya yazın
        String downloadFolderPath = "C:\\Users\\Yunus Emre ÜNLÜ\\Downloads"; // İndirme klasörünün yolu buraya yazın
        File downloadedFile = new File(downloadFolderPath + "/" + fileName);

        if (downloadedFile.exists()) {
            System.out.println("Dosya başarıyla indirildi. Dosya yolu: " + downloadedFile.getAbsolutePath());
        } else {
            System.out.println("Dosya indirilirken bir hata oluştu.");
        }

        driverCalıs.get("https://demoqa.com/browser-windows");
        WebElement tabbtn = driverCalıs.findElement(By.id("tabButton"));
        tabbtn.click();

        List<String> tabSayisi =new ArrayList<>(driverCalıs.getWindowHandles()); // tarayıcıdaki tab sayısını alıyor ve listeye atıyor
        System.out.println(tabSayisi);
        driverCalıs.switchTo().window(tabSayisi.get(1)); // açılan ikinci sekmeyi açar
        System.out.println(driverCalıs.getCurrentUrl()); // açılan sekmenin urlni alır

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }





        driverCalıs.get("https://demoqa.com/alerts");
        WebElement alert1 =driverCalıs.findElement(By.id("alertButton"));
        alert1.click();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        driverCalıs.switchTo().alert().accept();   // alerti kabul etme
       // driverCalıs.switchTo().alert().getText();  // alertteki yazıyı alma
       // driverCalıs.switchTo().alert().dismiss(); // alerti red ertme
       // driverCalıs.switchTo().alert().sendKeys("sssd"); // alerte yazı yazma


        driverCalıs.get("https://demoqa.com/frames");
        driverCalıs.switchTo().frame(1);  // frameleri indexler ile seçme
        WebElement frame = driverCalıs.findElement(By.id("sampleHeading")); // frame seçme
        String text = frame.getText();// değişkene atama
        System.out.println(text); // yazdırma
         driverCalıs.switchTo().parentFrame();  // frameden çıkma


    }


}
