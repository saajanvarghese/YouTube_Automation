package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    @Test
    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        // Navigate to YouTube Website
        driver.get("https://www.youtube.com/");
        // verifying the Current URL using Assert Statements
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.youtube.com/"), "Unverified URL");
        System.out.println("end Test case: testCase01");
    }

    @Test
    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        // // Navigate to YouTube Website
        // driver.get("https://www.youtube.com/");
        // verifying the Current URL using Assert Statements
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.youtube.com/"), "Unverified URL");
        System.out.println("Verified Link: URL: \"https://www.youtube.com/\" ");

        WebElement about_Element = driver.findElement(By.linkText("About"));

        SeleniumWrapper.clickAction(about_Element, driver);

        WebElement abouWebElementText1 = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[1]"));

        String aboutText1 = abouWebElementText1.getText();

        WebElement abouWebElementText2 = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[2]"));

        String aboutText2 = abouWebElementText2.getText();

        System.out.println("About: \n"+aboutText1+"\n"+aboutText2);

        System.out.println("end Test case: testCase02");
    }


}
