package POM;

import Actions.WeBElementActions;
import FileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {


    public static void Searching(WebDriver driver) {


        new WeBElementActions(driver)
                .sendKeysElement(new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Locators/SearchLocator"), WeBElementActions.Locators.Name,
                        WeBElementActions.ExpectedConditionsEnum.
                                ElementToBeClickable, new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPathfile).getValueOfNode("Data/SearchKeys"));
    }

}
