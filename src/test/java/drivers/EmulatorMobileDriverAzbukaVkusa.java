package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorMobileDriverAzbukaVkusa implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = new File("src/test/resources/apps/azbukavkusa/azbuka_vkusa_4.11.0.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Pixel 5 API 31");
        options.setPlatformVersion("12.0");
        options.setCapability("unicodeKeyboard", "true");
        options.setCapability("resetKeyboard", "true");
        options.setApp(app.getAbsolutePath());
        options.setAppPackage("ru.av.vkusomania");
        options.setAppActivity("ru.av.feature.main.screens.root.view.RootActivity");

        AndroidDriver driver = new AndroidDriver(getAppiumServerUrl(), options);
        return driver;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}
