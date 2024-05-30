// NB: The main function of the Tip Time App calculates tips, so there should be a local test that
// ensures that the tip calculation logic works correctly. To achieve this, you need to directly
// call the calculateTip() function like you did in the app code. Then you ensure that the value
// returned by the function matches an expected value based on the values that you passed to the
// function.
import com.example.tiptime.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    // NB: Lets the compiler know that the method is a test method and runs the method accordingly.
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        // NB: Tests typically end with an assertion, which is used to ensure that a given condition
        // is met. Assertions come in the form of a method call that has assert in its name.
        assertEquals(expectedTip, actualTip)
    }
}