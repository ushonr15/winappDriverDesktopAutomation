package cucumberOptions;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class GenericUtils {

    public static Properties getGlobalProperties() {

        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Global.properties");
            prop.load(fis);
        } catch (IOException e) {
            assertTrue("Failed to read Global.properties due to " + e.toString(), false);
        }
        return prop;
    }

    /**
     * Method to wait for provided number of seconds
     *
     * @param seconds : number of seconds
     */
    public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to wait till elements gets visible
     *
     * @param element Webelement to check its enable
     * @param seconds : number of seconds
     */
    public static boolean waitTillGetsVisible(WindowsDriver<WebElement> aut_driver, String name, int seconds) {
        List<WebElement> elements = aut_driver.findElementsByName(name);
        for (int i = 0; i <= seconds; i++) {
            if (elements.size() > 0) {
                return true;
            }
            GenericUtils.hardWait(1);
            elements = aut_driver.findElementsByName(name);
        }
        return false;
    }

    /**
     * Method to wait till elements gets enabled
     *
     * @param element Webelement to check its enabled
     * @param seconds : number of seconds
     */
    public static boolean waitTillGetsEnabled(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {
            try {
                if (Boolean.parseBoolean(element.getAttribute("IsEnabled")))
                    return true;
            } catch (Exception e) {
                GenericUtils.hardWait(1);
            }
        }
        return false;
    }

    public static void killAUT() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM CalculatorApp.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}