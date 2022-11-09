
import org.testng.annotations.Test
import screenobject.Screens.searchWelcome

class SearchTest :BaseTest() {


    @Test(description = "User can see the search screen")
    fun testWelcomeScreen(){
        Thread.sleep(10000)
        searchWelcome.assertWelcomeText("Welcome!");
    }
}