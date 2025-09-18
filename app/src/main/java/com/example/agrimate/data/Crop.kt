package com.example.agrimate.data

data class Crop(
    val id: Int,
    val name: String,
    val variety: String,
    val description: String,
    val imageRes: Int,
    val plantingInstructions: String,
    val fertilizerSchedule: String
)

