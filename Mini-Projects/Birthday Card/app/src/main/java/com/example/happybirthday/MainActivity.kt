package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    // Override the onCreate method to set the content view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content to a Composable function
        setContent {
            // Apply the app theme
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Call the GreetingImage composable function with message and from parameters
                    GreetingImage(message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Create a column to vertically arrange the texts
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()  // Make the column fill the entire available space
            .padding(8.dp)  // Add padding around the column
    ) {
        // The main message text
        Text(
            text = message,
            fontSize = 75.sp,  // Set the font size
            lineHeight = 116.sp,  // Set the line height
            textAlign = TextAlign.Center  // Center align the text
        )
        // Display the 'from' text
        Text(
            text = from,
            fontSize = 36.sp,  // Set the font size
            modifier = Modifier
                .padding(16.dp)  // Add padding around the text
                // Center align the text horizontally
                .align(alignment = Alignment.CenterHorizontally)
                .background(color = Color.Green)  // Set the background color
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Load the image resource
    val image = painterResource(R.drawable.androidparty)
    // Create a box to overlap the image and texts
    Box {
        // Display the image
        Image(
            painter = image,
            contentDescription = null,  // No content description for accessibility
            contentScale = ContentScale.Crop,  // Scale the image to fill the bounds
            alpha = 0.5F  // Set the transparency level of the image
        )
        // Call the GreetingText composable function to display the texts
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()  // Make the text fill the entire available space
                .padding(8.dp)  // Add padding around the text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    // Apply the app theme for the preview
    HappyBirthdayTheme {
        // Call the GreetingImage composable function with preview texts
        GreetingImage(stringResource(R.string.happy_birthday_text),
            stringResource(R.string.signature_text))
    }
}
