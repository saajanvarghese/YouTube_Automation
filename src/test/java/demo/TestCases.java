package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases extends ExcelDataProvider {
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

    @Test(enabled = true)
    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        // Navigate to YouTube Website
        driver.get("https://www.youtube.com/");
        // verifying the Current URL using Assert Statements
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.youtube.com/"), "Unverified URL");
        System.out.println("end Test case: testCase01");
    }

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
    public void testCase05() throws InterruptedException{

        System.out.println("Start Test case: testCase05");

        SoftAssert softassert = new SoftAssert();

        driver.navigate().back();

        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='endpoint']//yt-formatted-string[text()='News']")));

        WebElement newsSection = driver.findElement(By.xpath("//a[@id='endpoint']//yt-formatted-string[text()='News']"));
        SeleniumWrapper.clickAction(newsSection, driver);

        WebElement moviesTextElement = driver.findElement(By.xpath("//span[@class='yt-core-attributed-string yt-core-attributed-string--white-space-pre-wrap']"));
        String moviesText = moviesTextElement.getText();

        softassert.assertEquals(moviesText, "News");

        Thread.sleep(2000);

        WebElement Headline_1 = driver.findElement(By.xpath("(//yt-formatted-string[@id='home-content-text']//span)[1]"));
        String Headline_1_txt = Headline_1.getText();

        System.out.println("Headline 1 :"+Headline_1_txt);

        WebElement Headline_2 = driver.findElement(By.xpath("(//yt-formatted-string[@id='home-content-text']//span)[2]"));
        String Headline_2_txt = Headline_2.getText();

        System.out.println("\n Headline 2 :"+Headline_2_txt);

        WebElement Headline_3 = driver.findElement(By.xpath("(//span[@dir='auto'])[4]"));
        String Headline_3_txt = Headline_3.getText();

        System.out.println("\n Headline 3 :"+Headline_3_txt);

        double result = 0;

        WebElement HeadLine_1_Like_count = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[1]"));

        String getHeadLine_1_Like_count = HeadLine_1_Like_count.getText();

        WebElement HeadLine_2_Like_count = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[2]"));

        String getHeadLine_2_Like_count = HeadLine_2_Like_count.getText();

        WebElement HeadLine_3_Like_count = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[2]"));

        String getHeadLine_3_Like_count = HeadLine_3_Like_count.getText();

        if (getHeadLine_3_Like_count.contains("k")) {
            result = Double.parseDouble(getHeadLine_3_Like_count.replace("k", "")) * 1000;
        }

        
        int like_count_1 = Integer.parseInt(getHeadLine_1_Like_count);
        int like_count_2 = Integer.parseInt(getHeadLine_2_Like_count);
        int like_count_3 = Integer.parseInt(getHeadLine_3_Like_count);

        int result_likes = like_count_1 + like_count_2 + like_count_3;

        System.out.println("Total Count of Likes : "+ result_likes);
    }


    @Test(enabled = true, dataProvider = "excelData")
    public void testCase06(String Search_Keyword) throws InterruptedException {
        System.out.println("Start Test case: testCase06");

        driver.get("https://www.youtube.com/");

        driver.navigate().back();

        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));

        SeleniumWrapper.clickAction(searchBox, driver);

        SeleniumWrapper.enterText(searchBox, Search_Keyword);

        WebElement searchBoxClick = driver.findElement(By.id("search-icon-legacy"));

        SeleniumWrapper.clickAction(searchBoxClick, driver);
        List<WebElement> viewsList = driver.findElements(By.xpath("//span[contains(text(), 'views')]"));

        int actual_count = 0;
        String getViewCount = "";

        for (WebElement viewCount : viewsList) {
            String viewcountString = viewCount.getText();
            if (viewcountString.contains("M views")) {
                getViewCount = viewcountString.replace("M views", "");
            }
            if (viewcountString.contains("K views")) {
                getViewCount = viewcountString.replace("K views", "");
            }
            // String getViewCount = viewcountString.replace("M views", "");
            float numericviewCount = Float.parseFloat(getViewCount);
            actual_count += numericviewCount;

            if (actual_count >= 10000000) { // Checking if the total count reaches 10 million
                actual_count = 10000000; // Cap the count to 10 million
                break; // Exit the loop since the target has been reached
            }
        }

        System.out.println("Actual Count:" + actual_count);
    }
}