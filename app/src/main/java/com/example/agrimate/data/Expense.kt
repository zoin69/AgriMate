package com.example.agrimate.data

data class Expense(
    val id: Int,
    val title: String,
    val amount: String,
    val date: String,
    val category: String,
    val notes: String? = null
)

