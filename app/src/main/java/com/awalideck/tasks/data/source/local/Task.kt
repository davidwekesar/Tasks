package com.awalideck.tasks.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    val task: String,
    val isCompleted: Boolean,

    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L
)