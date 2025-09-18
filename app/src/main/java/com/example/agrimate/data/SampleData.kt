package com.example.agrimate.data

import com.example.agrimate.R

fun getSampleCrops(): List<Crop> {
    return listOf(
        Crop(
            id = 1,
            name = "Corn",
            variety = "High-yield variety",
            description = "Suitable for large-scale farming",
            imageRes = R.drawable.corn_icon,
            plantingInstructions = "Plant seeds 2 inches deep, spacing rows 30 inches apart. Ensure well-drained soil and full sunlight for optimal growth.",
            fertilizerSchedule = "Apply a balanced fertilizer (10–10–10) at planting. Side-dress with nitrogen when plants are knee-high. Monitor soil nutrient levels regularly."
        ),
        Crop(
            id = 2,
            name = "Soybeans",
            variety = "Drought-resistant",
            description = "Ideal for dry climates",
            imageRes = R.drawable.soybeans_icon,
            plantingInstructions = "Plant seeds 1 inch deep in rows 15 inches apart. Prefers well-drained soil with pH 6.0-7.0.",
            fertilizerSchedule = "Inoculate seeds with nitrogen-fixing bacteria. Apply phosphorus and potassium based on soil test results."
        ),
        Crop(
            id = 3,
            name = "Wheat",
            variety = "Winter wheat",
            description = "Good for cold regions",
            imageRes = R.drawable.wheat_icon,
            plantingInstructions = "Plant in fall for winter wheat. Sow seeds 1 inch deep in rows 6-8 inches apart.",
            fertilizerSchedule = "Apply nitrogen in early spring. Use split applications for better efficiency."
        ),
        Crop(
            id = 4,
            name = "Rice",
            variety = "Water-efficient",
            description = "Requires less water",
            imageRes = R.drawable.rice_icon,
            plantingInstructions = "Transplant seedlings 4-6 weeks after seeding. Maintain 2-3 inches of water depth.",
            fertilizerSchedule = "Apply nitrogen in three splits: at transplanting, tillering, and panicle initiation."
        ),
        Crop(
            id = 5,
            name = "Cotton",
            variety = "Long-staple cotton",
            description = "High-quality fiber",
            imageRes = R.drawable.cotton_icon,
            plantingInstructions = "Plant seeds 1 inch deep when soil temperature reaches 60°F. Space rows 30-40 inches apart.",
            fertilizerSchedule = "Apply nitrogen in split applications. Monitor for nutrient deficiencies throughout growing season."
        ),
        Crop(
            id = 6,
            name = "Tomatoes",
            variety = "Cherry tomatoes",
            description = "Perfect for home gardens",
            imageRes = R.drawable.tomatoes_icon,
            plantingInstructions = "Start seeds indoors 6-8 weeks before last frost. Transplant when soil is warm and danger of frost has passed.",
            fertilizerSchedule = "Use a balanced fertilizer at planting. Side-dress with nitrogen when first fruits appear."
        ),
        Crop(
            id = 7,
            name = "Potatoes",
            variety = "Russet potatoes",
            description = "Great for storage",
            imageRes = R.drawable.potatoes_icon,
            plantingInstructions = "Plant seed potatoes 4-6 inches deep in rows 30 inches apart. Hill soil around plants as they grow.",
            fertilizerSchedule = "Apply phosphorus and potassium at planting. Avoid high nitrogen which promotes foliage over tubers."
        ),
        Crop(
            id = 8,
            name = "Carrots",
            variety = "Nantes carrots",
            description = "Sweet and crunchy",
            imageRes = R.drawable.carrots_icon,
            plantingInstructions = "Sow seeds directly in garden 1/4 inch deep. Thin seedlings to 2 inches apart when 2 inches tall.",
            fertilizerSchedule = "Use low-nitrogen fertilizer. Too much nitrogen causes forked roots."
        ),
        Crop(
            id = 9,
            name = "Lettuce",
            variety = "Butterhead lettuce",
            description = "Fresh salad greens",
            imageRes = R.drawable.lettuce_icon,
            plantingInstructions = "Sow seeds 1/4 inch deep in rows 12 inches apart. Can be grown in partial shade.",
            fertilizerSchedule = "Use a balanced fertilizer. Avoid high nitrogen which can cause bitter taste."
        ),
        Crop(
            id = 10,
            name = "Peppers",
            variety = "Bell peppers",
            description = "Colorful and nutritious",
            imageRes = R.drawable.peppers_icon,
            plantingInstructions = "Start seeds indoors 8-10 weeks before last frost. Transplant when soil is warm.",
            fertilizerSchedule = "Use balanced fertilizer at planting. Side-dress with nitrogen when first flowers appear."
        ),
        Crop(
            id = 11,
            name = "Cucumbers",
            variety = "Pickling cucumbers",
            description = "Great for pickling",
            imageRes = R.drawable.cucumbers_icon,
            plantingInstructions = "Plant seeds 1 inch deep in hills 4-6 feet apart. Provide trellis for climbing varieties.",
            fertilizerSchedule = "Use balanced fertilizer at planting. Side-dress with nitrogen when vines start to run."
        ),
        Crop(
            id = 12,
            name = "Onions",
            variety = "Yellow onions",
            description = "Essential kitchen staple",
            imageRes = R.drawable.onions_icon,
            plantingInstructions = "Plant sets 1 inch deep in rows 12 inches apart. Space sets 4-6 inches apart.",
            fertilizerSchedule = "Use high-phosphorus fertilizer at planting. Avoid high nitrogen which delays bulb formation."
        )
    )
}

fun getSampleActivities(): List<Activity> {
    return listOf(
        Activity(
            id = 1,
            name = "Planting Corn",
            date = "2024-07-20",
            category = "Planting"
        ),
        Activity(
            id = 2,
            name = "Irrigation",
            date = "2024-07-22",
            category = "Watering"
        ),
        Activity(
            id = 3,
            name = "Fertilizing",
            date = "2024-07-25",
            category = "Fertilizing"
        ),
        Activity(
            id = 4,
            name = "Pest Control",
            date = "2024-07-28",
            category = "Pest Management"
        ),
        Activity(
            id = 5,
            name = "Harvesting",
            date = "2024-08-01",
            category = "Harvesting"
        )
    )
}

fun getSampleExpenses(): List<Expense> {
    return listOf(
        Expense(
            id = 1,
            title = "Fertilizer Purchase",
            amount = "250.00",
            date = "2024-07-20",
            category = "Supplies"
        ),
        Expense(
            id = 2,
            title = "Equipment Repair",
            amount = "120.00",
            date = "2024-07-22",
            category = "Maintenance"
        ),
        Expense(
            id = 3,
            title = "Seed Purchase",
            amount = "180.00",
            date = "2024-07-25",
            category = "Supplies"
        ),
        Expense(
            id = 4,
            title = "Labor Costs",
            amount = "300.00",
            date = "2024-07-28",
            category = "Labor"
        )
    )
}

