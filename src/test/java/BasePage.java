import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {
    FluentWait<WebDriver> wait;
    Logger logger = LogManager.getLogger(BasePage.class);

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        logger.info("tiklama basarili");
    }
        @Step("<wait> saniye kadar bekle")
        public void waitForseconds(int wait) throws InterruptedException {
            Thread.sleep(wait * 1000);
            logger.info(wait + " saniye bekleme başarili");
        }

    @Step("id<id> li elementi kontrol et")
    public void checkText(String id){
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA",chectText);
    }

    @Step("id<id> li elementi doğrula")
    public void shopping(String id){
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Market",chectText);
        logger.info("id li element kontrolu dogrulandı");
    }
    @Step("xpath <xpath> li elemente tıkla")
    public void clickByWithXpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        logger.info("xpath li elemente tiklama basarili");
    }
    @Step("Sayfayı aşağı kaydır")
    public void swipeUp() {
        final int ANIMATION_TIME = 2000; // ms
        final int PRESS_TIME = 2000; // ms
        int edgeBorder = 2; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2,edgeBorder);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
        logger.info("Sayfa asagi kaydirildi.");

    }
    @Step("Rasgele bir ürün seç")
    public void selectRondamproduct(){
        Random rdn = new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        System.out.println("pd"  +pd);
        MobileElement element =  pd.get(rdn.nextInt(pd.size()));
        System.out.println("element"  +element);
        element.click();
    }
    @Step("id<id> li elementi kontrol ett")
    public void checkText1(String id){
        String chectText1 = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Renk:",chectText1);
    }
    @Step("id<id> li elementi kontrol ettt")
    public void checkText2(String id){
        String chectText2 = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Parola",chectText2);
    }
    @Step("<id> id'li elemente <email> email adresi girme")
    public void loginMail(String emailId,String emailText){
        appiumDriver.findElement(By.id(emailId)).sendKeys(emailText);
        logger.info("Mail adresi girildi");
    }

    @Step("<id> 'li elemente <password> şifre girme")
    public void loginPassword(String passwordId, String passwordText){
        appiumDriver.findElement(By.id(passwordId)).sendKeys(passwordText);
        logger.info("Sifre girildi");
    }

    @Step("id<id> geri tusuna tıkla")
    public void clickGeri(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }


    @Step("<id> sepete ekleme yap")
    public  void SepeteEkle(String sepetId){
        appiumDriver.findElement(By.id(sepetId)).click();
        logger.info("Sepete ekle tusuna basildi");
    }
    }








