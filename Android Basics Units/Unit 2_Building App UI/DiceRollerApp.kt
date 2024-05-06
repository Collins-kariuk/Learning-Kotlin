// Package declaration.
package com.example.diceroller

// Import necessary libraries and components from Android and Compose frameworks.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

// MainActivity class which is the entry point of the app, inheriting from ComponentActivity.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content of the UI.
        setContent {
            // Apply the custom Material Theme.
            DiceRollerTheme {
                // Surface container that fills the entire screen.
                Surface(
                    modifier = Modifier.fillMaxSize(), // Fill the maximum size of the parent container.
                    color = MaterialTheme.colorScheme.background // Use the background color from the theme.
                ) {
                    // Call the DiceRollerApp composable function to build the UI.
                    DiceRollerApp()
                }
            }
        }
    }
}

// Preview annotation for Android Studio to render a preview of the UI.
@Preview
@Composable
fun DiceRollerApp() {
    // DiceWithButtonAndImage composable function with center alignment.
    DiceWithButtonAndImage(
        modifier = Modifier
        .fillMaxSize() // Fills the maximum size of the parent.
        .wrapContentSize(Alignment.Center) // Centers the content inside the parent.
    )
}

// Composable function to display a dice image and a button to roll the dice.
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // Remember a mutable state for the result of the dice roll.
    var result by remember { mutableStateOf(1) } // Initial state set to 1.

    // Choose the dice image based on the current result.
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6 // Default case for any other value.
    }

    // Column layout to arrange the image and button vertically and center-aligned horizontally.
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // Display the dice image.
        Image(painter = painterResource(id = imageResource), contentDescription = result.toString())

        // Button to roll the dice.
        Button(
            // Set result to a random number between 1 and 6 when clicked.
            onClick = { result = (1..6).random() },
        ) {
            // Text inside the button.
            // Text to display and its font size.
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}
