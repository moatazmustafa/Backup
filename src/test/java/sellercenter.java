//package org.example;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class sellercenter {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cache", "--disable-application-cache", "--incognito");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void sellerCenterAssertionText() {
        driver.get("https://www.raneen.com/en");
        driver.manage().window().setSize(new Dimension(1440, 797));
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mr3483490@gmail.com");
        driver.findElement(By.id("am-pass")).sendKeys("571998@Mr");
        driver.findElement(By.id("customer-form-login-popup-send2")).click();
        // driver.findElement(By.cssSelector(".amsl-button")).click();
        try {
            Thread.sleep(10000); // Wait for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".switch")).click();
        try {
            Thread.sleep(5000); // Wait for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        js.executeScript("window.scrollTo(0,1)");
        js.executeScript("window.scrollTo(0,76)");
        assertThat(driver.findElement(By.cssSelector("#openStatements > .title")).getText(), is("Open Statements"));
        assertThat(driver.findElement(By.cssSelector("#closedStatements > .title")).getText(), is("Closed Statements"));
        assertThat(driver.findElement(By.cssSelector("#paidStatements > .title")).getText(), is("Paid Statements"));
        assertThat(driver.findElement(By.cssSelector("#enabledProducts > .title")).getText(), is("Enabled Products"));
        assertThat(driver.findElement(By.cssSelector("#disabledProducts > .title")).getText(), is("Disabled Products"));
        assertThat(driver.findElement(By.cssSelector("#inStockProducts > .title")).getText(), is("In Stock Products"));
        assertThat(driver.findElement(By.cssSelector("#outOfStockProducts > .title")).getText(), is("Low Stock Products"));
        assertThat(driver.findElement(By.cssSelector("#pendingShipments > .title")).getText(), is("Pending Shipments"));
        assertThat(driver.findElement(By.cssSelector("#cancelledShipments > .title")).getText(), is("Cancelled Shipments"));
        assertThat(driver.findElement(By.cssSelector("#inProcessShipments > .title")).getText(), is("In Process Shipments"));
        assertThat(driver.findElement(By.cssSelector("#packedShipments > .title")).getText(), is("Packed Shipments"));
        assertThat(driver.findElement(By.cssSelector("#shippedShipments > .title")).getText(), is("Shipped"));
        assertThat(driver.findElement(By.cssSelector("#deliveredShipments > .title")).getText(), is("Delivered"));
        assertThat(driver.findElement(By.cssSelector("#failedDeliveryShipments > .title")).getText(), is("Failed Delivery"));
        assertThat(driver.findElement(By.cssSelector("#underInvestigationShipments > .title")).getText(), is("Under Investigation"));
        driver.findElement(By.cssSelector("#openStatements > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#closedStatements > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#paidStatements > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#enabledProducts > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#disabledProducts > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#inStockProducts > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#outOfStockProducts > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#pendingShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#cancelledShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#inProcessShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#packedShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#shippedShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#deliveredShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#failedDeliveryShipments > .title")).click();
        driver.findElement(By.linkText("Marketplace Dashboard")).click();
        driver.findElement(By.cssSelector("#underInvestigationShipments > .title")).click();
        js.executeScript("window.scrollTo(0,68)");
        js.executeScript("window.scrollTo(0,165)");
        js.executeScript("window.scrollTo(0,61)");
    }
}
