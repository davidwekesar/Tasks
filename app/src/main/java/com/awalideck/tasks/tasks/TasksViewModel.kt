package com.awalideck.tasks.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.awalideck.tasks.TaskRepository
import com.awalideck.tasks.data.source.local.Task

class TasksViewModel(repository: TaskRepository): ViewModel() {

    val allTasks: LiveData<List<Task>> = repository.allTasks.asLiveData()
}

class TasksViewModelFactory(private val repository: TaskRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TasksViewModel::class.java)) {
            return TasksViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}