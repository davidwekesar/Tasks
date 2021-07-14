package com.awalideck.tasks.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.awalideck.tasks.R
import com.awalideck.tasks.TasksApplication
import com.awalideck.tasks.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TasksViewModel by viewModels {
        TasksViewModelFactory((activity?.application as TasksApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)

        viewModel.allTasks.observe(viewLifecycleOwner, {taskList->
            val adapter = TaskAdapter(taskList)
            binding.tasksRecyclerView.adapter = adapter
        })

        binding.addFab.setOnClickListener {
            val action = R.id.action_tasksFragment_to_addEditTaskFragment
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}