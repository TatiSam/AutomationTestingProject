package extensions;

import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class Verifications extends CommonOps {

    public static void verifyTextEquals(String actual, String expected) {
        assertEquals(actual, expected);
    }

    public static void verifyTextContains(String text, String str) {
        assertTrue(text.contains(str));
    }

    public static void verifyCountMore(int count, int min) {
        assertTrue(count > min);
    }

    public static void verifyCountEquals(int count1, int count2) {
        assertTrue(count1 == count2);
    }

    public static void verifyCountEquals(double count1, double count2) {
        assertTrue(count1 == count2);
    }

    public static void isDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }
}
