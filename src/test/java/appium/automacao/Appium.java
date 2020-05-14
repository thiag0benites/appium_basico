package appium.automacao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Appium {
	
	AppiumDriver<MobileElement> driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("browserName", "Chrome");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void buscaPalavra() throws InterruptedException {
		driver.findElementByName("q").sendKeys("appium");
		Thread.sleep(5000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
