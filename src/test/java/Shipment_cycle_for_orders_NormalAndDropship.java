import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.core.Is;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import javax.swing.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.openqa.selenium.support.ui.Select;

public class Shipment_cycle_for_orders_NormalAndDropship {

    WebDriver driver;
    @BeforeTest
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void shutdown() {
        driver.quit();
    }
    @Test
    public void open_screen_setup() throws InterruptedException {

        driver.get("https://www.raneen.com/admin/admin/");  //open magento
        driver.findElement(By.cssSelector("#username")).sendKeys("motaz.mostafa");  //user name
        driver.findElement(By.cssSelector("#login")).sendKeys("mm@123456");  //password
        driver.findElement(By.cssSelector("#login-form > fieldset > div.form-actions > div.actions > button")).click();  //sign in
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#menu-magento-catalog-catalog > a")).click();  // catalog
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#menu-magento-catalog-catalog > div > ul > li.item-inventory.parent.level-1 > div > ul > li.item-catalog-products.level-2 > a")).click();  //products
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"fulltext\"]")).clear();  // product search field
        driver.findElement(By.xpath("//*[@id=\"fulltext\"]")).sendKeys("test33"); //
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  // search
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#idscheck413176")).click();  // checkbox
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > button")).click();  // mass action
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > div > ul > li._parent > span")).click();  //change status
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > div > ul > li._parent._visible > ul > li:nth-child(1) > span")).click();  //enable
        Thread.sleep(10000);


        driver.switchTo().newWindow(WindowType.TAB);
        Object[] windowHandles1 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles1 [1]);  // website


        driver.get("https://www.raneen.com/ar/catalog/product/view/id/413176");
        driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li.link.authorization-link")).click();  //
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys("motaz.mostafa@raneen.com");  //
        driver.findElement(By.cssSelector("#am-pass")).sendKeys("mm@123456");  //
        driver.findElement(By.cssSelector("#customer_form_login_popup_showPassword")).click();  //
        driver.findElement(By.cssSelector("#customer-form-login-popup-send2")).click();  //sign in
        Thread.sleep(25000);
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();  //add t cart
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#ammenu-header-container > div.header.content > div.minicart-wrapper > a")).click();  //show cart
        driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();  //proceed to checkout
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();  //shipping method
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#cashondelivery")).click();  //
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#agreement_cashondelivery_3")).click();  //terms button
        driver.findElement(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button")).click();  //place order
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[0]); //magento


        driver.findElement(By.cssSelector("#menu-magento-sales-sales > a")).click();  //sales
        Thread.sleep(70000);    //50000
        driver.findElement(By.cssSelector("#menu-magento-sales-sales > div > ul > li:nth-child(1) > ul > li > div > ul > li.item-sales-order.level-2 > a")).click();  //orders
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#fulltext")).clear();  //
        driver.findElement(By.cssSelector("#fulltext")).sendKeys("sellertow");  //
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  //search button
        Thread.sleep(20000);
        String ordernumber =driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td:nth-child(2) > div")).getText(); // copy order number
        assertThat(driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td:nth-child(5) > div")).getText(),is("test sellertow"));
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td.data-grid-actions-cell > a")).click();  //view
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#order_invoice")).click();  //invoice
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/section[4]/section[2]/div[2]/div[2]/div[2]/div[3]/button")).click();  //submit
        Thread.sleep(30000);

        Object[] windowHandles3 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles3 [1]); //website

        driver.findElement(By.xpath("//*[@id=\"ammenu-header-container\"]/div[1]/div/ul/li[2]/span")).click();  //
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ammenu-header-container\"]/div[1]/div/ul/li[2]/div/ul/li[1]")).click();  //my account
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#block-collapsible-nav > ul > li:nth-child(3) > a")).click();  //seller shipments
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#seller-shipments-table > tbody > tr:nth-child(1) > td.col.action > a")).click();  //view more
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#dropship")).click();  //
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#in_process_button")).click();  //
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#packed_button")).click();  //
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#shipped_button")).click();  //
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#delivered_button")).click();  //
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div.column.main > div:nth-child(8) > div > div.shipment-delivered.active.done")).getText(),is("تم التوصيل"));
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div:nth-child(1) > div > div")).getText(),is("تم تطبيق الإجراء بنجاح"));

        Object[] windowHandles4 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles4 [0]); //magento

        driver.findElement(By.cssSelector("#menu-ocean-marketplaceseller-parent > a")).click();  //marketplace
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#menu-ocean-marketplaceseller-parent > div > ul > li:nth-child(2) > ul > li.item-statementitems.parent.level-1 > div > ul > li.item-marketplacestatementitem.level-2 > a")).click();  //statement items
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_post_filter_order_id")).clear();  //
        driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_post_filter_order_id")).sendKeys(ordernumber);  //paste order number
        driver.findElement(By.cssSelector("#id_9iCNiSYIkrnqX64bNOvYoeRCw6ifaj4P")).click();  // search
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_table > tbody > tr > td.col-seller_id")).getText(),is("testsellertwo"));
        assertThat(driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_table > tbody > tr > td.col-shipment_delivery_type")).getText(),is("Dropship"));

        Object[] windowHandles5 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles5 [1]); //website

        driver.findElement(By.cssSelector("#block-collapsible-nav > ul > li:nth-child(15) > a")).click();  //my orders
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#my-orders-table > tbody > tr:nth-child(1) > td.col.actions > a.action.order")).click();  //re-order
        Thread.sleep(18000);
        assertThat(driver.findElement(By.cssSelector("#cart-totals > div > table > tbody > tr.grand.totals > td > strong > span")).getText(),is("400.00 جنيه"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.cart-container > div.cart-summary > ul > li > button")).click();  // proceed t checkout
        Thread.sleep(11000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();  //shipping methods
        Thread.sleep(15000);
        driver.findElement(By.cssSelector("#cashondelivery")).click();  // cash on delivery
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#agreement_cashondelivery_3")).click();  // terms & conditions
        driver.findElement(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button")).click();  //place order
        Thread.sleep(6000);

        Object[] windowHandles6 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles6 [0]); //magento

        driver.findElement(By.cssSelector("#menu-magento-sales-sales > a")).click();  //sales
        Thread.sleep(70000);    //50000
        driver.findElement(By.cssSelector("#menu-magento-sales-sales > div > ul > li:nth-child(1) > ul > li > div > ul > li.item-sales-order.level-2 > a")).click();  //orders
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#fulltext")).clear();  //
        driver.findElement(By.cssSelector("#fulltext")).sendKeys("sellertow");  //
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  //search button
        Thread.sleep(20000);
        String ordernumber2 =driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td:nth-child(2) > div")).getText(); // copy order number
        assertThat(driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td:nth-child(5) > div")).getText(),is("test sellertow"));
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td.data-grid-actions-cell > a")).click();  //view
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#order_invoice")).click();  //invoice
        Thread.sleep(10000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/section[4]/section[2]/div[2]/div[2]/div[2]/div[3]/button")).click();  //submit
        Thread.sleep(50000);
        driver.navigate().refresh();
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#sales_order_view_tabs_order_shipments")).click();  //shipments
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#sales_order_view_tabs_order_shipments_content > div > div.admin__data-grid-wrap > table > tbody > tr > td.data-grid-actions-cell > a")).click();  //view shipment
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/button[4]")).click();  //in process
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/button[4]")).click();  //pack
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#menu-ocean-marketplaceseller-parent > a")).click();  //marketplace
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#menu-ocean-marketplaceseller-parent > div > ul > li:nth-child(2) > ul > li.item-statementitems.parent.level-1 > div > ul > li.item-marketplacestatementitem.level-2 > a")).click();  //statement items
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_post_filter_order_id")).clear();  //
        driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_post_filter_order_id")).sendKeys(ordernumber2);  //paste order number
        driver.findElement(By.cssSelector("#id_9iCNiSYIkrnqX64bNOvYoeRCw6ifaj4P")).click();  // search
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_table > tbody > tr > td.col-seller_id")).getText(),is("testsellertwo"));
        assertThat(driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_table > tbody > tr > td.col-shipment_delivery_type")).getText(),is("Normal"));
        Thread.sleep(10000);
    }
}