package screenobject.search

import org.openqa.selenium.WebElement
import org.testng.Assert
import screenobject.BaseScreen

class Search : BaseScreen() {
    private val welcomeElement: WebElement get() = driver.findElementById("simpleSearchWelcome")

    fun getWelcomeText():String {
        return welcomeElement?.text ?: ""
    }

    fun assertWelcomeText(expectedText: String) {
        Assert.assertEquals(getWelcomeText(), expectedText, "Welcome Text is not the same as expectation")
    }
}