package com.awalideck.tasks

import androidx.annotation.WorkerThread
import com.awalideck.tasks.data.source.local.Task
import com.awalideck.tasks.data.source.local.TaskDao
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    @WorkerThread
    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
}