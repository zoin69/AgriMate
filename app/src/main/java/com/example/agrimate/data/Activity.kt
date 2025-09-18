package com.example.agrimate.data

import java.util.Date

data class Activity(
    val id: Int,
    val name: String,
    val date: String,
    val category: String,
    val notes: String? = null
)

