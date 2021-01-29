package com.awalideck.tasks.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    val task: String,
    val isCompleted: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0
}