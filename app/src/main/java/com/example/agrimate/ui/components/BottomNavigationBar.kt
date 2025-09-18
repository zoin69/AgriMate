package com.example.agrimate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agrimate.navigation.Screen
import com.example.agrimate.ui.theme.*

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val navItems = listOf(
        NavItem("Home", Icons.Default.Home, Screen.Dashboard.route),
        NavItem("Guides", Icons.Default.MenuBook, Screen.CropGuides.route),
        NavItem("Activities", Icons.Default.CalendarToday, Screen.Activities.route),
        NavItem("Expenses", Icons.Default.AttachMoney, Screen.Expenses.route),
        NavItem("Settings", Icons.Default.Settings, Screen.Settings.route)
    )

        Surface(
            modifier = modifier.fillMaxWidth(),
            color = CardBackground,
            shadowElevation = 12.dp
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navItems.forEach { item ->
                BottomNavItem(
                    item = item,
                    isSelected = currentRoute == item.route,
                    onClick = { navController.navigate(item.route) }
                )
            }
        }
    }
}

@Composable
fun BottomNavItem(
    item: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.label,
            tint = if (isSelected) PrimaryGreen else TextMedium,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.label,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) PrimaryGreen else TextMedium
        )
    }
}

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

