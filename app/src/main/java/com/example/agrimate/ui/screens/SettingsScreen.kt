package com.example.agrimate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agrimate.navigation.Screen
import com.example.agrimate.ui.components.BottomNavigationBar
import com.example.agrimate.ui.theme.*

@Composable
fun SettingsScreen(navController: NavController) {
    var notificationsEnabled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWhite)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
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
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = TextDark
                    )
                }
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
                Spacer(modifier = Modifier.width(48.dp)) // Balance the back button
            }

            // Settings Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                // General Section
                SettingsSection(
                    title = "General",
                    items = listOf(
                        SettingsItem(
                            title = "Language",
                            subtitle = "English",
                            icon = Icons.Default.Settings,
                            onClick = { /* TODO: Language selection */ }
                        ),
                        SettingsItem(
                            title = "Notifications",
                            subtitle = "Enable notifications",
                            icon = Icons.Default.Settings,
                            isToggle = true,
                            toggleValue = notificationsEnabled,
                            onToggleChange = { notificationsEnabled = it }
                        )
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Profile Section
                SettingsSection(
                    title = "Profile",
                    items = listOf(
                        SettingsItem(
                            title = "Profile",
                            subtitle = "Edit your profile",
                            icon = Icons.Default.Person,
                            onClick = { /* TODO: Profile editing */ }
                        )
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Account Section
                SettingsSection(
                    title = "Account",
                    items = listOf(
                        SettingsItem(
                            title = "Account",
                            subtitle = "Manage your account",
                            icon = Icons.Default.Settings,
                            onClick = { /* TODO: Account management */ }
                        )
                    )
                )

                Spacer(modifier = Modifier.height(80.dp)) // Space for bottom navigation
            }
        }

        // Bottom Navigation - Fixed at bottom
        BottomNavigationBar(
            currentRoute = Screen.Settings.route,
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun SettingsSection(
    title: String,
    items: List<SettingsItem>
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = TextDark,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardBackground,
                contentColor = TextDark
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column {
                items.forEachIndexed { index, item ->
                    SettingsItemRow(
                        item = item,
                        showDivider = index < items.size - 1
                    )
                }
            }
        }
    }
}

@Composable
fun SettingsItemRow(
    item: SettingsItem,
    showDivider: Boolean
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { item.onClick() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = TextLight,
                modifier = Modifier.size(24.dp)
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = TextDark
                )
                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextLight
                )
            }
            
            if (item.isToggle) {
                Switch(
                    checked = item.toggleValue ?: false,
                    onCheckedChange = item.onToggleChange ?: {},
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = BackgroundWhite,
                        checkedTrackColor = PrimaryGreen,
                        uncheckedThumbColor = BackgroundWhite,
                        uncheckedTrackColor = TextLight
                    )
                )
            } else {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Navigate",
                    tint = TextLight,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        
        if (showDivider) {
            Divider(
                color = TextLight.copy(alpha = 0.2f),
                modifier = Modifier.padding(start = 56.dp)
            )
        }
    }
}

data class SettingsItem(
    val title: String,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val isToggle: Boolean = false,
    val toggleValue: Boolean? = null,
    val onToggleChange: ((Boolean) -> Unit)? = null,
    val onClick: () -> Unit = {}
)
