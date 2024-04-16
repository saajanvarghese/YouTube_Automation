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
        try {
            // Navigate to YouTube Website
        driver.get("https://www.youtube.com/");
        // verifying the Current URL using Assert Statements
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.youtube.com/"), "Unverified URL");
        System.out.println("end Test case: testCase01");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test(enabled = true)
    public  void testCase02(){
        System.out.println("Start Test case: testCase02");

        try {
            // Implementing Soft Assert
        SoftAssert softassert = new SoftAssert();
        // verifying the Current URL using Assert Statements
        softassert.assertTrue(driver.getCurrentUrl().equals("https://www.youtube.com/"), "Unverified URL");
        System.out.println("Verified Link: URL: \"https://www.youtube.com/\" ");

        // Locate About
        WebElement about_Element = driver.findElement(By.linkText("About"));

        // Click About
        SeleniumWrapper.clickAction(about_Element, driver);

        // Locate About Message 1
        WebElement abouWebElementText1 = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[1]"));

        // Convert About Message 1 to String
        String aboutText1 = abouWebElementText1.getText();

        // Locate About Message 2
        WebElement abouWebElementText2 = driver.findElement(By.xpath("//section[@class='ytabout__content']//p[2]"));

        // Convert About Message 2 to String
        String aboutText2 = abouWebElementText2.getText();

        //Print the Messages in Terminal
        System.out.println("About: \n"+aboutText1+"\n"+aboutText2);

        // Verify All Assert statements using AssertAll();
        softassert.assertAll();
        
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("end Test case: testCase02");
    }

    @Test(enabled = true)
    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");

        try {
            // Implementing Soft Assert
        SoftAssert softassert = new SoftAssert();

        // Navigate to Previous Page
        driver.navigate().back();

        // Locate Movies Element
        WebElement moviesSection = driver.findElement(By.xpath("//yt-formatted-string[text()='Movies']"));

        // Click on Movies
        SeleniumWrapper.clickAction(moviesSection, driver);

        // Locate Movies Text
        WebElement moviesTextElement = driver.findElement(By.xpath("//span[text()='Movies']"));

        // Convert Movies Text to String
        String moviesText = moviesTextElement.getText();

        //Implementing assertEquals in SoftAssert to verify Movies Text
        softassert.assertEquals(moviesText, "Movies");

        Thread.sleep(2000);

        // Locate Right Arrow button
        WebElement rightArrowbtn = driver.findElement(By.xpath("(//ytd-button-renderer[@class='style-scope yt-horizontal-list-renderer arrow'])[2]"));
        // Loop until the element disappears
        while (rightArrowbtn.isDisplayed()) {
            // Click on the element
            rightArrowbtn.click();

            Thread.sleep(1000);
        }

        // Locate Rating Element
        WebElement A_Rating = driver.findElement(By.xpath("(//p[text()='A'])[3]"));

        // Convert Rating Element to String
        String A_Rating_txt = A_Rating.getText();

        //Implementing assertEquals in SoftAssert to verify 'A' Rating
        softassert.assertEquals(A_Rating_txt, "A");

        // Print the Rating in the Terminal
        System.out.println("Verified Maturity for the Movie : "+A_Rating_txt);

        // Locate Genre Element
        WebElement movieGenere = driver.findElement(By.xpath("(//span[contains(text(), 'Comedy')])[3]"));

        // Convert Genre Element to String
        String movieGeneretxt = movieGenere.getText();

        //Implementing assertEquals in SoftAssert to verify Genre as 'Comedy' or not
        softassert.assertTrue(movieGeneretxt.contains("Comedy"), "Unverified Genre");

        // Print the Genre in the Terminal
        System.out.println("Verified Genre for the Movie : "+movieGeneretxt);

         // Verify All Assert statements using AssertAll()
        softassert.assertAll();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("end Test case: testCase03");
    }

    //@Test(enabled = true)
    public void testCase04() throws InterruptedException{

        try {
            System.out.println("Start Test case: testCase04");

        // Implementing Soft Assert
        SoftAssert softassert = new SoftAssert();

        // Navigate to Previous Page
        driver.navigate().back();

        // Locate Music Element
        WebElement musicSection = driver.findElement(By.xpath("//a[@id='endpoint']//yt-formatted-string[text()='Music']"));

        // Click on Music
        SeleniumWrapper.clickAction(musicSection, driver);

        // Locate Music Text
        WebElement musicTextElement = driver.findElement(By.xpath("//yt-formatted-string[@id='title'][text()='Music']"));

        // Convert Movies Text to String
        String moviesText = musicTextElement.getText();

        //Implementing assertEquals in SoftAssert to verify Music Text
        softassert.assertEquals(moviesText, "Music");

        Thread.sleep(2000);

        // Locate Right Arrow button
        WebElement rightArrowbtn = driver.findElement(By.xpath("(//ytd-button-renderer[@class='style-scope yt-horizontal-list-renderer arrow'])[4]"));
        // Loop until the element disappears
        while (rightArrowbtn.isDisplayed()) {
            // Click on the element
            rightArrowbtn.click();

            Thread.sleep(1000);
        }

        // Loccate PlayList Track Name
        WebElement playListTrackName = driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-compact-station-renderer']//h3)[11]"));

        // Convert PlayList Track Name to Text
        String playListTracktxt = playListTrackName.getText();

        // Print the Track List Name in Terminal
        System.out.println("PlayList Track Name : "+playListTracktxt);

        //Locate TrackList
        WebElement TrackList = driver.findElement(By.xpath("(//div[@class='flex-container style-scope ytd-compact-station-renderer']//p[@id='video-count-text'])[11]"));

        //Convert TrackList To String
        String TrackListtxt = TrackList.getText();

        //Implementing assertEquals in SoftAssert to verify 50 tracks or not
        softassert.assertEquals(TrackListtxt, "50 tracks");

         // Verify All Assert statements using AssertAll()
        softassert.assertAll();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }  
        System.out.println("end Test case: testCase04");  
    }

    @Test(enabled = true)
    public void testCase05() throws InterruptedException{

        try {
            System.out.println("Start Test case: testCase05");

            // Implementing Soft Assert
        SoftAssert softassert = new SoftAssert();

        // Navigate to Previous Page
        driver.navigate().back();

        Thread.sleep(3000);

        // Implement WebDriverWait to wait until Element is Clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='endpoint']//yt-formatted-string[text()='News']")));

       // Locate News Element
        WebElement newsSection = driver.findElement(By.xpath("//a[@id='endpoint']//yt-formatted-string[text()='News']"));

        // Click on News
        SeleniumWrapper.clickAction(newsSection, driver);

        // Locate News Text
        WebElement newsTextElement = driver.findElement(By.xpath("//span[@class='yt-core-attributed-string yt-core-attributed-string--white-space-pre-wrap']"));

        // Convert Movies Text to String
        String newsText = newsTextElement.getText();

        //Implementing assertEquals in SoftAssert to verify News Text
        softassert.assertEquals(newsText, "News");

        Thread.sleep(2000);

        // Locate Headline 1
        WebElement Headline_1 = driver.findElement(By.xpath("(//yt-formatted-string[@id='home-content-text']//span)[1]"));
        // Convert Headline 1 to String
        String Headline_1_txt = Headline_1.getText();
        // Print Headline 1 in Terminal
        System.out.println("Headline 1 :"+Headline_1_txt);

        // Locate Headline 2
        WebElement Headline_2 = driver.findElement(By.xpath("(//yt-formatted-string[@id='home-content-text']//span)[2]"));
         // Convert Headline 2 to String
        String Headline_2_txt = Headline_2.getText();
        // Print Headline 2 in Terminal
        System.out.println("\n Headline 2 :"+Headline_2_txt);

         // Locate Headline 3
        WebElement Headline_3 = driver.findElement(By.xpath("(//span[@dir='auto'])[4]"));
        // Convert Headline 3 to String
        String Headline_3_txt = Headline_3.getText();
        // Print Headline 3 in Terminal
        System.out.println("\n Headline 3 :"+Headline_3_txt);

        double result = 0;

        // Locate Headline 1 Like Count
        WebElement HeadLine_1_Like_count = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[1]"));
        // Convert Headline 1 Like Count to String
        String getHeadLine_1_Like_count = HeadLine_1_Like_count.getText();
        // Locate Headline 2 Like Count
        WebElement HeadLine_2_Like_count = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[2]"));
        // Convert Headline 2 Like Count to String
        String getHeadLine_2_Like_count = HeadLine_2_Like_count.getText();
        // Locate Headline 3 Like Count
        WebElement HeadLine_3_Like_count = driver.findElement(By.xpath("(//span[@id='vote-count-middle'])[3]"));
        // Convert Headline 3 Like Count to String
        String getHeadLine_3_Like_count = HeadLine_3_Like_count.getText();

        // If Like Count contains 'k', then remove k
        if (getHeadLine_3_Like_count.contains("k")) {
            result = Double.parseDouble(getHeadLine_3_Like_count.replace("k", "")) * 1000;
        }

        // Convert Headline 1 Like Count to Integer
        int like_count_1 = Integer.parseInt(getHeadLine_1_Like_count);
        // Convert Headline 2 Like Count to Integer
        int like_count_2 = Integer.parseInt(getHeadLine_2_Like_count);
        // Convert Headline 2 Like Count to Integer
        int like_count_3 = Integer.parseInt(getHeadLine_3_Like_count);

        // Add All the Like Count
        int result_likes = like_count_1 + like_count_2 + like_count_3;

        // Print Total Like Count in Terminal
        System.out.println("Total Count of Likes : "+ result_likes);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("end Test case: testCase05");
    }


    @Test(enabled = true, dataProvider = "excelData")
    public void testCase06(String Search_Keyword) throws InterruptedException {

        try {
            System.out.println("Start Test case: testCase06");

        // Navigate to Previous Page
        driver.navigate().back();

        Thread.sleep(3000);

        // Locate Dearch Element
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));

        // Click on Search Text Box
        SeleniumWrapper.clickAction(searchBox, driver);

        //Enter Keywords to Search
        SeleniumWrapper.enterText(searchBox, Search_Keyword);

        // Locate Search Button
        WebElement searchBoxClick = driver.findElement(By.id("search-icon-legacy"));

        //lick on Search Button
        SeleniumWrapper.clickAction(searchBoxClick, driver);

        //Get a List of Views using List of WebElement
        List<WebElement> viewsList = driver.findElements(By.xpath("//span[contains(text(), 'views')]"));

        // Declare the viewCount initially as 0
        int actual_count = 0;
        // Declare a Empty String for the View Count
        String getViewCount = "";

        for (WebElement viewCount : viewsList) {
            String viewcountString = viewCount.getText();

            //If viewCount Contains 'M views', remove 'M views'
            if (viewcountString.contains("M views")) {
                getViewCount = viewcountString.replace("M views", "");
            }
            //If viewCount Contains 'K views', remove 'K views'
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

        // Print Total View Count in Terminal
        System.out.println("Actual Count:" + actual_count);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("end Test case: testCase06");
    }
}