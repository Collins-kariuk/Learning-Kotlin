/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    // Override the onCreate method to set the content view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content to a Composable function
        setContent {
            // Apply the app theme
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call the ComposeQuadrantApp composable function
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

// Composable function to display the main content of the app
@Composable
fun ComposeQuadrantApp() {
    // Create a column to arrange the rows vertically
    Column(Modifier.fillMaxWidth()) {
        // First row of info cards
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        // Second row of info cards
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Composable function to display an info card
@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    // Create a column to arrange the texts vertically
    Column(
        modifier = modifier
            .fillMaxSize()  // Make the column fill the entire available space
            .background(backgroundColor)  // Set the background color
            .padding(16.dp),  // Add padding around the column
        verticalArrangement = Arrangement.Center,  // Center align the children vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center align the children horizontally
    ) {
        // Display the title text
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),  // Add padding at the bottom of the text
            fontWeight = FontWeight.Bold  // Set the font weight to bold
        )
        // Display the description text
        Text(
            text = description,
            textAlign = TextAlign.Justify  // Justify the text
        )
    }
}

// Composable function to preview the ComposeQuadrantApp
@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    // Apply the app theme for the preview
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}
