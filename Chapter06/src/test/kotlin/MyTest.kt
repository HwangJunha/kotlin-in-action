import com.around.MyService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Asserter
import kotlin.test.Test

class MyTest{
    private lateinit var myService: MyService
    @BeforeEach fun setup(){
        myService = MyService()
    }

    @Test fun testMyService(){
        Assertions.assertNotNull(myService)
        myService.performAction()

    }
}