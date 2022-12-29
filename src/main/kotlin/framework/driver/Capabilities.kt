package framework.driver

import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.ios.options.XCUITestOptions
import util.App

object Capabilities {

    fun Android(): UiAutomator2Options {
        val capabilities = UiAutomator2Options()
        capabilities.setCapability("platformName", "Android")
        capabilities.setCapability("appium:platformVersion", "11.0")
        capabilities.setCapability("appium:deviceName", "Pixel XL")
        capabilities.setCapability("appium:automationName", "UIAutomator2")
        capabilities.setCapability("appium:newCommandTimeout", 300)
        capabilities.setCapability("appium:autoGrantPermissions", true)
        capabilities.setCapability("appium:appPackage", "ch.homegate.mobile.alpha")
        capabilities.setCapability("appium:appActivity", "ch.homegate.mobile.search.SearchActivity")
        capabilities.setCapability("appium:app", App.androidWLPath)
        capabilities.setCapability("appium:version", "v2.0.0-beta.46")


        return capabilities
    }

    fun iOS(): XCUITestOptions {
        val capabilities = XCUITestOptions()
        capabilities.setCapability("platformName", "iOS")
        capabilities.setCapability("appium:platformVersion", "16.1")
        capabilities.setCapability("appium:deviceName", "iPhone 14 Pro")
        capabilities.setCapability("appium:automationName", "XCUITest")
        capabilities.setCapability("appium:noReset", false)
        capabilities.setCapability("appium:newCommandTimeout", 600)
        capabilities.setCapability("appium:simulatorStartupTimeout", 600000)
        capabilities.setCapability("appium:isHeadless", false)
        capabilities.setCapability("appium:maxTypingFrequency", 20)
        capabilities.setCapability("appium:app", App.androidWLPath)

        return capabilities
    }

}