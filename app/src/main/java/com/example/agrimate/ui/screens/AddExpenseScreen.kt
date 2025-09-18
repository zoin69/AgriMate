package com.example.agrimate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agrimate.data.Expense
import com.example.agrimate.data.Repository
import com.example.agrimate.navigation.Screen
import com.example.agrimate.ui.components.BottomNavigationBar
import com.example.agrimate.ui.components.DatePickerField
import com.example.agrimate.ui.components.DropdownField
import com.example.agrimate.ui.theme.*

@Composable
fun AddExpenseScreen(navController: NavController) {
    var expenseTitle by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
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
                text = "Add Expense",
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

            // Expense Title Field
            OutlinedTextField(
                value = expenseTitle,
                onValueChange = { expenseTitle = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Expense Title", color = PrimaryGreen) },
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

            // Amount Field
            OutlinedTextField(
                value = amount,
                onValueChange = { newValue ->
                    // Only allow numbers and one decimal point
                    if (newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                        amount = newValue
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Amount", color = PrimaryGreen) },
                leadingIcon = {
                    Text(
                        text = "$",
                        color = TextDark,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
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

            // Date Field
            DatePickerField(
                value = date,
                onValueChange = { date = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Date"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Category Field
            DropdownField(
                value = category,
                onValueChange = { category = it },
                options = Repository.expenseCategories,
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
                    println("DEBUG: Save button clicked!")
                    println("DEBUG: Title: '$expenseTitle' (length: ${expenseTitle.length})")
                    println("DEBUG: Amount: '$amount' (length: ${amount.length})")
                    println("DEBUG: Date: '$date' (length: ${date.length})")
                    println("DEBUG: Category: '$category' (length: ${category.length})")
                    
                    val isTitleValid = expenseTitle.isNotEmpty()
                    val isAmountValid = amount.isNotEmpty()
                    val isDateValid = date.isNotEmpty()
                    val isCategoryValid = category.isNotEmpty()
                    
                    println("DEBUG: Validation - Title: $isTitleValid, Amount: $isAmountValid, Date: $isDateValid, Category: $isCategoryValid")
                    
                    if (isTitleValid && isAmountValid && isDateValid && isCategoryValid) {
                        val newExpense = Expense(
                            id = 0, // Will be set by repository
                            title = expenseTitle,
                            amount = amount,
                            date = date,
                            category = category,
                            notes = notes.takeIf { it.isNotEmpty() }
                        )
                        println("DEBUG: Adding expense: $newExpense")
                        Repository.addExpense(newExpense)
                        println("DEBUG: Expense added, navigating to expenses")
                        navController.navigate(Screen.Expenses.route) {
                            popUpTo(Screen.AddExpense.route) { inclusive = true }
                        }
                    } else {
                        println("DEBUG: Form validation failed - missing required fields")
                        println("DEBUG: Please fill in all required fields")
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
                    text = "Save Expense",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(80.dp)) // Space for bottom navigation
        }

        // Bottom Navigation
        BottomNavigationBar(
            currentRoute = Screen.Expenses.route,
            navController = navController
        )
    }
}

