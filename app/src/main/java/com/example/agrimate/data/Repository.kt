package com.example.agrimate.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

object Repository {
    private val _activities = mutableStateListOf<Activity>()
    val activities: SnapshotStateList<Activity> = _activities

    private val _expenses = mutableStateListOf<Expense>()
    val expenses: SnapshotStateList<Expense> = _expenses

    private var nextActivityId = 1
    private var nextExpenseId = 1

    init {
        // Initialize with sample data
        _activities.addAll(getSampleActivities())
        _expenses.addAll(getSampleExpenses())
        nextActivityId = _activities.maxOfOrNull { it.id }?.plus(1) ?: 1
        nextExpenseId = _expenses.maxOfOrNull { it.id }?.plus(1) ?: 1
    }

    fun addActivity(activity: Activity) {
        val newActivity = activity.copy(id = nextActivityId++)
        _activities.add(newActivity)
    }

    fun deleteActivity(activityId: Int) {
        _activities.removeAll { it.id == activityId }
    }

    fun addExpense(expense: Expense) {
        val newExpense = expense.copy(id = nextExpenseId++)
        _expenses.add(newExpense)
    }

    fun deleteExpense(expenseId: Int) {
        _expenses.removeAll { it.id == expenseId }
    }

    val activityCategories = listOf(
        "Planting",
        "Watering",
        "Fertilizing",
        "Pest Management",
        "Harvesting",
        "Pruning",
        "Weeding",
        "Soil Preparation"
    )

    val expenseCategories = listOf(
        "Supplies",
        "Equipment",
        "Labor",
        "Maintenance",
        "Seeds",
        "Fertilizer",
        "Transportation",
        "Utilities"
    )
}
