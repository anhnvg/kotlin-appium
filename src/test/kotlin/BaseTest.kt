import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import framework.driver.AutomateDriver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import util.EnvironmentManager
import util.getModule

open class BaseTest : KoinComponent {
    private val automateDriver by inject<AutomateDriver>()

    @BeforeSuite
    fun initModule() {
        startKoin {
            modules(getModule(EnvironmentManager.platform))
        }
    }

    @BeforeMethod
    fun initDriver() {
        automateDriver.initDriver()
    }

    @AfterMethod(description = "Screenshot | Video", alwaysRun = true)
    fun afterTest(result: ITestResult) {
        if (!result.isSuccess) {
            println("HELLO ANH THIS TEST IS FAILED")
        }
    }

    @AfterSuite
    fun tearDown() {
        automateDriver.driver.quit()
    }
}

