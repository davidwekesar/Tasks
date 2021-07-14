package com.awalideck.tasks

import android.app.Application
import com.awalideck.tasks.data.source.local.TaskDatabase

class TasksApplication: Application() {

    private val database by lazy { TaskDatabase.getDatabase(this) }
    val repository by lazy { TaskRepository(database.taskDao()) }
}