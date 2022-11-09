package screenobject

import framework.driver.AutomateDriver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseScreen : KoinComponent {
    val driver by inject<AutomateDriver>()
}