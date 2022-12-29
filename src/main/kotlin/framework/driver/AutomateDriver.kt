package framework.driver

import framework.AppiumServerManager
import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.WebElement
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

interface AutomateDriver {
    var driver: AppiumDriver
    fun initDriver()
    fun findElementById(id:String): WebElement
    fun findElementByAccessibilityId(id: String): WebElement
    fun findElementsById(id: String): List<WebElement>
}

abstract class BaseAutomateDriver : AutomateDriver {
    override var driver: AppiumDriver by ThreadLocalDelegate.lateinit()

    override fun findElementByAccessibilityId(id: String): WebElement {
        return driver.findElement(AppiumBy.accessibilityId(id))
    }

    protected fun setImplicityWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }
}

class AndroidAutomateDriver : BaseAutomateDriver() {

    override fun initDriver() {
        driver = AndroidDriver(URL(AppiumServerManager.serverAddress), Capabilities.Android())
        setImplicityWait()
    }

    override fun findElementById(id: String): WebElement {
        return driver.findElement(AppiumBy.id(id))
    }

    override fun findElementsById(id: String): List<WebElement> {
        return driver.findElements(AppiumBy.id(id))
    }
}

class IOSAutomateDriver : BaseAutomateDriver() {
    override fun initDriver() {
        driver = IOSDriver(URL(AppiumServerManager.serverAddress), Capabilities.iOS())
        setImplicityWait()
    }

    override fun findElementById(id: String): WebElement {
        return driver.findElement(AppiumBy.accessibilityId(id))
    }

    override fun findElementsById(id: String): List<WebElement> {
        return driver.findElements(AppiumBy.id(id))
    }
}