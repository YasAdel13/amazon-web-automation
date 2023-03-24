package amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@Test
public class Amazon {
    private WebDriver driver;

    @Test
    public void setup() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void enterAmazonEgypt (){
        setup();
        driver.findElement(By.name("q")).sendKeys("amazon egypt");
    }
    @Test
    public void ClickSearchButton(){
        enterAmazonEgypt();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
    }
    @Test
    public void clickAmazon(){
        ClickSearchButton();
        driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
    }

    @Test
    public void searchBarInAmazon(){
        clickAmazon();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("labtop hp");
    }
    @Test
    public void clickSearchBar(){
        searchBarInAmazon();
        driver.findElement(By.id("nav-search-submit-text")).click();
    }
    @Test
    public void languageButton (){
        clickSearchBar();
        driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i")).click();
        driver.findElement(By.xpath("//*[@id=\"icp-save-button\"]/span/input")).click();
    }
    @Test
    public void brand(){
        languageButton();
        driver.findElement(By.xpath("//*[@id=\"p_89/HP\"]/span/a/div/label/i")).click();
    }
    @Test
    public void price(){
        brand();
        driver.findElement(By.name("low-price")).sendKeys("20000");
        driver.findElement(By.name("high-price")).sendKeys("25000");
        driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div[2]/div[3]/div/a/span[1]/span[2]/span[2]")).click();
    }
    @Test
    public void addToCart(){
        price();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    public static void main(String[] args) {

    }











}
