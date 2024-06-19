package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // NB (1): Composables are stateless by default, which means that they don't hold a value and
    // can be recomposed any time by the system, which results in the value being reset. However,
    // Compose provides a convenient way to avoid this. Composable functions can store an object in
    // memory using the remember composable.

    // NB (2): The mutableStateOf() function returns an observable which basically means that when
    // the value of the result variable changes, a recomposition is triggered, the value of the
    // result is reflected, and the UI refreshes.
    var result by remember { mutableIntStateOf( 1) }

    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = result.toString())

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            // NB (1): The braces, in this case, represent what is known as a lambda, the area
            // inside of the braces being the lambda body. When a function is passed as an argument,
            // it can also be referred to as a "callback".

            // NB (2): A lambda is a function literal, which is a function like any other, but
            // instead of being declared separately with the fun keyword, it is written inline and
            // passed as an expression.

            // Randomly generates a number between 1 and 6 and assigns it to the result variable
            onClick = { result = (1..6).random() },
        ) {
            // Text that is displayed on the button
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize() // So the layout fills the entire screen.
        .wrapContentSize(Alignment.Center) // So the text is centered vertically and horizontally.
    )
}