package SearchTests;
import FileWrappers.LoggingHandling;
import FileWrappers.ReadDataFromJSonFile;
import POM.GoogleSearchPage;
import POM.SearchingResultPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithValidDataTest extends BaseTest {

    @Description("2- Step: Search for Instabug keyword")
    @Test
    public void testSearchPage()
    {
        GoogleSearchPage.Searching(getDriver());

    }
    @Description("3- Step: Scroll down on first page")
    @Test(dependsOnMethods = "testSearchPage")
    public void testResultScrollDown()  {
        try {
            SearchingResultPage.scrollingTill(getDriver());

        } catch (InterruptedException e) {
            LoggingHandling.logError(e);
        }
    }
    @Description("4- Step: Navigate to page two")
    @Test(dependsOnMethods = "testResultScrollDown")
    public void testNavigateToSecondPage()  {
        SearchingResultPage.clickOnNext(getDriver());
        Assert.assertTrue(SearchingResultPage.getTest(getDriver(),
                new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile)
                        .getValueOfNode("Locators/ResultStatusLocator")).contains("Page 2"));

    }
    @Description("5- Step: Count of result")
    @Test(dependsOnMethods = "testNavigateToSecondPage")
    public void testCountResultsDisplayedOnTheSecondPage()  {

        //Assert.assertEquals((SearchingResultPage.countOfResult(getDriver())>=10?true:false),true);
        Assert.assertEquals((SearchingResultPage.countOfResult(getDriver())),10);
        System.out.print("Count=" + SearchingResultPage.countOfResult(getDriver()) );
    }
    @Description("6- Step: Scroll down on Second page")
    @Test(dependsOnMethods = "testCountResultsDisplayedOnTheSecondPage")
    public void scrollDownOnSecondPage()  {
        try {
            SearchingResultPage.scrollingTill(getDriver());

        } catch (InterruptedException e) {
            LoggingHandling.logError(e);
        }
    }
    @Description("7- Step: Navigate to page Third page")
    @Test(dependsOnMethods = "scrollDownOnSecondPage")
    public void testNavigateToThirdpage()  {

        SearchingResultPage.clickOnNext(getDriver());
        Assert.assertTrue(SearchingResultPage.getTest(getDriver(),
                new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile)
                        .getValueOfNode("Locators/ResultStatusLocator")).contains("Page 3"));
    }
}