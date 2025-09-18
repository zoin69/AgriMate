# 🌾 AgriMate - Android Farming Companion App

A beautiful, modern Android application built with Jetpack Compose for farmers to track activities, manage expenses, and access crop guides.

## ✨ Features

- **🌱 Crop Guides**: Detailed information about 12 different crops with planting instructions and fertilizer schedules
- **📊 Activity Tracking**: Log and manage daily farm activities with categories and dates
- **💰 Expense Management**: Track farm expenses with proper currency formatting
- **🎨 Beautiful UI**: Modern design with 60-30-10 color rule and smooth animations
- **📱 Material Design 3**: Following latest Android design guidelines

## 🛠️ Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM
- **Navigation**: Navigation Compose
- **Design**: Material Design 3
- **Animations**: Compose Animation APIs

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24 or higher
- Kotlin 1.8.0 or later

### Installation
1. Clone this repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Run on device or emulator

## 📁 Project Structure

```
app/src/main/java/com/example/agrimate/
├── data/                    # Data classes and repository
├── navigation/              # Navigation setup
├── ui/
│   ├── components/          # Reusable UI components
│   ├── screens/            # App screens
│   └── theme/              # Colors, typography, themes
└── MainActivity.kt         # Main activity
```

## 🎨 Design System

- **Primary Color**: Forest Green (#2E7D32)
- **Secondary Color**: Light Green (#66BB6A)
- **Accent Color**: Gold (#FFC107)
- **Typography**: Material Design 3 typography scale
- **Spacing**: 4dp, 8dp, 16dp, 24dp system

## 🔧 Key Features

### Activity Management
- Add new farm activities
- Categorize activities (Planting, Watering, Fertilizing, etc.)
- Date picker for activity scheduling
- Delete activities with confirmation

### Expense Tracking
- Track farm expenses with dollar formatting
- Number-only input validation
- Category-based expense organization
- Real-time expense calculations

### Crop Information
- 12 different crop varieties
- Detailed planting instructions
- Fertilizer schedules
- Growing tips and best practices

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## 🙏 Acknowledgments

- Material Design 3 guidelines
- Jetpack Compose documentation
- Android development community
