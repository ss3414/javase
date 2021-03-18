package library.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    /* 节点 */
    @Test
    public void element() {
        System.setProperty("webdriver.firefox.driver", "C:/Program Files/RunningCheeseFirefox/Firefox/geckodriver.exe");
        WebDriver browser = new FirefoxDriver();
        browser.get("http://bbs.wuyou.net");
        browser.close();
    }

}
