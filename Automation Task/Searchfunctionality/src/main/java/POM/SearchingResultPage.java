package POM;

import Actions.WeBElementActions;
import FileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class SearchingResultPage {


    public static void scrollingTill( WebDriver driver) throws InterruptedException {

        new WeBElementActions(driver).ScrollWithJS(new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Locators/NextLinkLocator"),WeBElementActions.Locators.id);
    }
    public static void clickOnNext(WebDriver driver ){
        new WeBElementActions(driver).clickingElement(new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Locators/NextLinkLocator"),WeBElementActions.Locators.id, WeBElementActions.ExpectedConditionsEnum.ElementToBeClickable);
    }
    public static  int countOfResult(WebDriver driver ) {
        List<WebElement> Result = driver.findElements(new WeBElementActions(driver).returnElementLocatorBy(new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Locators/CountOfResultLinks"), WeBElementActions.Locators.XPath));
        return Result.size();
    }
    public static String getTest(WebDriver driver , String selector)
    {
        return (new WeBElementActions(driver).waitUntilCanValidate(
                (new WeBElementActions(driver).returnElementLocatorBy(selector, WeBElementActions.Locators.id))
                , WeBElementActions.ExpectedConditionsEnum.presenceOfElement)).getText();
    }

}
