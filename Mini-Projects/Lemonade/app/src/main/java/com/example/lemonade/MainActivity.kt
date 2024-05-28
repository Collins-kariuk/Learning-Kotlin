package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    // Current step the app is displaying (remember allows the state to be retained across
    // recompositions).
    var currentStep by remember { mutableIntStateOf(1) }
    // Number of squeezes required to make lemonade
    var squeezeCount by remember { mutableIntStateOf(0) }

    // Scaffold composable provides a layout structure with a top bar and a content area.
    Scaffold(
        topBar = {
            // CenterAlignedTopAppBar is a top app bar with a centered title.
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        // Surface composable provides a background for the app's content area.
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            // Display content based on the current step.
            when (currentStep) {
                1 -> {
                    // Step 1: Display the lemon tree and set the current step to 2 on image click.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_select,
                        drawableResourceId = R.drawable.lemon_tree,
                        contentDescriptionResourceId = R.string.lemon_tree_content_description,
                        onImageClick = {
                            currentStep = 2
                            // Randomly set the number of squeezes required.
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    // Step 2: Display the lemon and decrease squeeze count on image click.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_squeeze,
                        drawableResourceId = R.drawable.lemon_squeeze,
                        contentDescriptionResourceId = R.string.lemon_content_description,
                        onImageClick = {
                            squeezeCount--
                            // Move to the next step when squeezing is done.
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                3 -> {
                    // Step 3: Display the lemonade and set the current step to 4 on image click.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_drink,
                        drawableResourceId = R.drawable.lemon_drink,
                        contentDescriptionResourceId = R.string.lemonade_content_description,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                4 -> {
                    // Step 4: Display the empty glass and reset the current step to 1 on click.
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_empty_glass,
                        drawableResourceId = R.drawable.lemon_restart,
                        contentDescriptionResourceId = R.string.empty_glass_content_description,
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}


@Composable
/**
 * NB (1): You can make any composable, not just buttons, clickable when you specify the clickable
 * modifier on it.
 *
 * */
fun LemonTextAndImage(
    textLabelResourceId: Int, // Resource ID for the text label
    drawableResourceId: Int, // Resource ID for the drawable image
    contentDescriptionResourceId: Int, // Resource ID for the content description
    onImageClick: () -> Unit, // Lambda function to handle image click events
    modifier: Modifier = Modifier // Modifier to style the composable
) {
    // Box layout to stack elements on top of each other
    Box(
        modifier = modifier
    ) {
        // Column layout to arrange elements vertically
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center align horizontally
            verticalArrangement = Arrangement.Center, // Center align vertically
            modifier = Modifier.fillMaxSize() // Fill the entire available space
        ) {
            // Button composable with an image inside it
            Button(
                onClick = onImageClick, // Handle button click
                // Rounded corners
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme
                    .colorScheme
                    .tertiaryContainer) // Button background color
            ) {
                // Image composable to display the drawable resource
                Image(
                    painter = painterResource(drawableResourceId), // Load image from resources
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width)) // Set image width
                        .height(dimensionResource(R.dimen.button_image_height)) // Set image height
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }

            // Spacer composable to add vertical space
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))

            // Text composable to display the text label
            Text(
                text = stringResource(textLabelResourceId), // Load text from resources
                style = MaterialTheme.typography.bodyLarge // Apply text style
            )
        }
    }
}

@Preview
@Composable
fun LemonPreview() {
    AppTheme() {
        LemonadeApp()
    }
}