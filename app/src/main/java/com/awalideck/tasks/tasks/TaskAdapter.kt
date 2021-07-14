package com.awalideck.tasks.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.awalideck.tasks.data.source.local.Task
import com.awalideck.tasks.databinding.ListItemTaskBinding

class TaskAdapter(private val taskList: List<Task>): RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemTaskBinding.inflate(layoutInflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}

class TaskViewHolder(binding: ListItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    private val taskTextView: TextView = binding.task

    fun bind(task: Task) {
        taskTextView.text = task.task
    }
}