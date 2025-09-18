package com.example.agrimate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agrimate.data.Activity
import com.example.agrimate.data.Repository
import com.example.agrimate.navigation.Screen
import com.example.agrimate.ui.components.BottomNavigationBar
import com.example.agrimate.ui.components.DatePickerField
import com.example.agrimate.ui.components.DropdownField
import com.example.agrimate.ui.theme.*

@Composable
fun AddActivityScreen(navController: NavController) {
    var activityName by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWhite)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = TextDark
                )
            }
            Text(
                text = "Add Activity",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )
            Spacer(modifier = Modifier.width(48.dp)) // Balance the close button
        }

        // Form Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Activity Name Field
            OutlinedTextField(
                value = activityName,
                onValueChange = { activityName = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Activity name", color = PrimaryGreen) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryGreen,
                    unfocusedBorderColor = LightGreen,
                    focusedTextColor = TextDark,
                    unfocusedTextColor = TextDark,
                    focusedContainerColor = LightGreen,
                    unfocusedContainerColor = LightGreen
                ),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Date & Time Field
            DatePickerField(
                value = dateTime,
                onValueChange = { dateTime = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Date & time"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Category Field
            DropdownField(
                value = category,
                onValueChange = { category = it },
                options = Repository.activityCategories,
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Category"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Notes Field
            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                placeholder = { Text("Notes", color = PrimaryGreen) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryGreen,
                    unfocusedBorderColor = LightGreen,
                    focusedTextColor = TextDark,
                    unfocusedTextColor = TextDark,
                    focusedContainerColor = LightGreen,
                    unfocusedContainerColor = LightGreen
                ),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Save Button
            Button(
                onClick = { 
                    println("DEBUG: Save activity button clicked!")
                    println("DEBUG: Name: '$activityName', Date: '$dateTime', Category: '$category'")
                    
                    if (activityName.isNotEmpty() && dateTime.isNotEmpty() && category.isNotEmpty()) {
                        val newActivity = Activity(
                            id = 0, // Will be set by repository
                            name = activityName,
                            date = dateTime,
                            category = category,
                            notes = notes.takeIf { it.isNotEmpty() }
                        )
                        println("DEBUG: Adding activity: $newActivity")
                        Repository.addActivity(newActivity)
                        println("DEBUG: Activity added, navigating to activities")
                        navController.navigate(Screen.Activities.route) {
                            popUpTo(Screen.AddActivity.route) { inclusive = true }
                        }
                    } else {
                        println("DEBUG: Activity form validation failed - missing required fields")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryGreen,
                    contentColor = BackgroundWhite
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Save Activity",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(80.dp)) // Space for bottom navigation
        }

        // Bottom Navigation
        BottomNavigationBar(
            currentRoute = Screen.Activities.route,
            navController = navController
        )
    }
}

