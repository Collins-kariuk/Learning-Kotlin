package com.example.jetpackcomposetutorial

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialText(header = stringResource(R.string.header),
                        paraOne = stringResource(R.string.FirstParagraph),
                        paraTwo = stringResource(R.string.SecondParagraph))
                }
            }
        }
    }
}

@Composable
fun TopImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image (
        painter = image,
        contentDescription = "A banner for the tutorials page which displaying colorful widgets",
        contentScale = ContentScale.FillWidth
        )
    }

@Composable
fun TutorialText(header: String, paraOne: String, paraTwo: String, modifier: Modifier = Modifier) {
    // Create a Column so that texts don't overlap
    Column(
        verticalArrangement = Arrangement.Center
        // Add modifier here if necessary
    ) {
        // Add padding to the header
        Text(
            text = header,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paraOne,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paraTwo,
            modifier = Modifier.padding(start = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                TopImage()
                TutorialText(header = stringResource(R.string.header),
                    paraOne = stringResource(R.string.FirstParagraph),
                    paraTwo = stringResource(R.string.SecondParagraph))
            }
        }
    }
}
