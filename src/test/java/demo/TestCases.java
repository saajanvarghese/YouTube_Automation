package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

        SoftAssert softassert = new SoftAssert();
        // verifying the Current URL using Assert Statements
        softassert.assertTrue(driver.getCurrentUrl().equals("https://www.youtube.com/"), "Unverified URL");
        System.out.println("Verified Link: URL: \"https://www.youtube.com/\" ");

        WebElement about_Element = driver.findElement(By.linkText("About"));

        SeleniumWrapper.clickAction(about_Element, driver);

        WebElement abouWebElementText1 = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[1]"));

        String aboutText1 = abouWebElementText1.getText();

        WebElement abouWebElementText2 = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[2]"));

        String aboutText2 = abouWebElementText2.getText();

        System.out.println("About: \n"+aboutText1+"\n"+aboutText2);

        softassert.assertAll();

        System.out.println("end Test case: testCase02");
    }

    @Test
    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        SoftAssert softassert = new SoftAssert();

        driver.navigate().back();

        WebElement moviesSection = driver.findElement(By.xpath("//yt-formatted-string[text()='Movies']"));
        SeleniumWrapper.clickAction(moviesSection, driver);

        WebElement moviesTextElement = driver.findElement(By.xpath("//span[text()='Movies']"));
        String moviesText = moviesTextElement.getText();


        softassert.assertEquals(moviesText, "Movies");

        Thread.sleep(2000);

        WebElement rightArrowbtn = driver.findElement(By.xpath("(//ytd-button-renderer[@class='style-scope yt-horizontal-list-renderer arrow'])[2]"));
        // Loop until the element disappears
        while (rightArrowbtn.isDisplayed()) {
            // Click on the element
            rightArrowbtn.click();

            Thread.sleep(1000);
        }

        WebElement A_Rating = driver.findElement(By.xpath("(//p[text()='A'])[3]"));

        String A_Rating_txt = A_Rating.getText();

        softassert.assertEquals(A_Rating_txt, "A");

        System.out.println("Verified Maturity for the Movie : "+A_Rating_txt);

        WebElement movieGenere = driver.findElement(By.xpath("(//span[contains(text(), 'Comedy')])[3]"));

        String movieGeneretxt = movieGenere.getText();

        softassert.assertTrue(movieGeneretxt.contains("Comedy"), "Unverified Genre");

        System.out.println("Verified Genre for the Movie : "+movieGeneretxt);

        softassert.assertAll();

        System.out.println("end Test case: testCase03");
    }

    @Test
    public void testCase04() throws InterruptedException{

        System.out.println("Start Test case: testCase04");

        SoftAssert softassert = new SoftAssert();

        driver.navigate().back();


        WebElement moviesSection = driver.findElement(By.xpath("//a[@id='endpoint']//yt-formatted-string[text()='Music']"));
        SeleniumWrapper.clickAction(moviesSection, driver);


        WebElement moviesTextElement = driver.findElement(By.xpath("//yt-formatted-string[@id='title'][text()='Music']"));
        String moviesText = moviesTextElement.getText();

        softassert.assertEquals(moviesText, "Music");

        Thread.sleep(2000);

        WebElement rightArrowbtn = driver.findElement(By.xpath("(//ytd-button-renderer[@class='style-scope yt-horizontal-list-renderer arrow'])[4]"));
        // Loop until the element disappears
        while (rightArrowbtn.isDisplayed()) {
            // Click on the element
            rightArrowbtn.click();

            Thread.sleep(1000);
        }

        WebElement playListTrackName = driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-compact-station-renderer']//h3)[11]"));

        String playListTracktxt = playListTrackName.getText();

        System.out.println("PlayList Track Name : "+playListTracktxt);

        WebElement TrackList = driver.findElement(By.xpath("(//div[@class='flex-container style-scope ytd-compact-station-renderer']//p[@id='video-count-text'])[11]"));

        String TrackListtxt = TrackList.getText();

        softassert.assertEquals(TrackListtxt, "50 tracks");

        softassert.assertAll();

        System.out.println("end Test case: testCase04");

    }
}
