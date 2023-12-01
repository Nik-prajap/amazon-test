package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setupBrowser() {
        openBrowserForSetUp(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDellLaptopPageSuccessfully() throws InterruptedException {

        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), ("Dell Laptop"));
        Thread.sleep(2000);

        mouseHoverAndClickOnElement(By.id("nav-search-submit-button"));

        mouseHoverAndClickOnElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]"));
        //Thread.sleep(2000);

        driver.getCurrentUrl();
        Thread.sleep(2000);

        List<WebElement> allProducts = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int countProducts = allProducts.size();
        System.out.println("Total Products Displayed : " + countProducts);
        for (WebElement e : allProducts) {
            System.out.println(e.getText());
        }


        clickOnElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[15]"));

        String expectedText = "Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver";
        String actualText = getTextFromElement(By.xpath("(//span[@id='productTitle'])[1]"));
        Assert.assertEquals(expectedText,actualText);



    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
