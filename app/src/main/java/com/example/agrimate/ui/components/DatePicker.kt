package com.example.agrimate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.agrimate.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DatePickerField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Select Date"
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val dateFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    Box(modifier = modifier) {
        // Custom clickable field
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(LightGreen)
                .border(
                    width = 1.dp,
                    color = LightGreen,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable { 
                    println("DEBUG: Date field clicked!")
                    showDatePicker = true 
                }
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (value.isEmpty()) placeholder else value,
                    color = if (value.isEmpty()) PrimaryGreen else TextDark,
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Spacer(modifier = Modifier.weight(1f))
                
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = "Date Picker",
                    tint = TextDark
                )
            }
        }
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDateSelected = { selectedDate ->
                onValueChange(dateFormatter.format(selectedDate))
                showDatePicker = false
            },
            onDismiss = { showDatePicker = false }
        )
    }
}

@Composable
fun DatePickerDialog(
    onDateSelected: (Date) -> Unit,
    onDismiss: () -> Unit
) {
    var selectedDate by remember { mutableStateOf(Date()) }
    val dateFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = BackgroundWhite
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Select Date",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )
                    
                    TextButton(onClick = onDismiss) {
                        Text("Cancel", color = TextLight)
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Custom Date Picker
                CustomDatePicker(
                    selectedDate = selectedDate,
                    onDateChanged = { selectedDate = it }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text("Cancel", color = TextLight)
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Button(
                        onClick = {
                            onDateSelected(selectedDate)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryGreen
                        )
                    ) {
                        Text("Select", color = BackgroundWhite)
                    }
                }
            }
        }
    }
}

@Composable
fun CustomDatePicker(
    selectedDate: Date,
    onDateChanged: (Date) -> Unit
) {
    val calendar = Calendar.getInstance()
    calendar.time = selectedDate
    
    var currentYear by remember { mutableStateOf(calendar.get(Calendar.YEAR)) }
    var currentMonth by remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
    var currentDay by remember { mutableStateOf(calendar.get(Calendar.DAY_OF_MONTH)) }
    
    val monthNames = arrayOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )
    
    Column {
        // Year and Month Selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Year
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Year",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextLight
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { currentYear-- }
                    ) {
                        Text("◀", color = PrimaryGreen, style = MaterialTheme.typography.titleMedium)
                    }
                    Text(
                        text = currentYear.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    IconButton(
                        onClick = { currentYear++ }
                    ) {
                        Text("▶", color = PrimaryGreen, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
            
            // Month
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Month",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextLight
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { 
                            currentMonth = if (currentMonth > 0) currentMonth - 1 else 11
                        }
                    ) {
                        Text("◀", color = PrimaryGreen, style = MaterialTheme.typography.titleMedium)
                    }
                    Text(
                        text = monthNames[currentMonth],
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    IconButton(
                        onClick = { 
                            currentMonth = if (currentMonth < 11) currentMonth + 1 else 0
                        }
                    ) {
                        Text("▶", color = PrimaryGreen, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Day Selection
        Text(
            text = "Day",
            style = MaterialTheme.typography.bodyMedium,
            color = TextLight,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { 
                    if (currentDay > 1) currentDay--
                }
            ) {
                Text("◀", color = PrimaryGreen, style = MaterialTheme.typography.titleMedium)
            }
            
            Text(
                text = currentDay.toString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            
            IconButton(
                onClick = { 
                    val daysInMonth = Calendar.getInstance().apply {
                        set(currentYear, currentMonth, 1)
                    }.getActualMaximum(Calendar.DAY_OF_MONTH)
                    if (currentDay < daysInMonth) currentDay++
                }
            ) {
                Text("▶", color = PrimaryGreen, style = MaterialTheme.typography.titleMedium)
            }
        }
        
        // Update the selected date
        LaunchedEffect(currentYear, currentMonth, currentDay) {
            val newCalendar = Calendar.getInstance()
            newCalendar.set(currentYear, currentMonth, currentDay)
            onDateChanged(newCalendar.time)
        }
    }
}