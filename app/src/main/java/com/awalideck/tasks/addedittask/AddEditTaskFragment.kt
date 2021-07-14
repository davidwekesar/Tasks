package com.awalideck.tasks.addedittask

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.awalideck.tasks.R
import com.awalideck.tasks.TasksApplication
import com.awalideck.tasks.data.source.local.Task
import com.awalideck.tasks.databinding.FragmentAddEditTaskBinding
import com.google.android.material.snackbar.Snackbar

class AddEditTaskFragment : Fragment() {

    private var _binding: FragmentAddEditTaskBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddEditViewModel by viewModels {
        AddEditViewModelFactory((activity?.application as TasksApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEditTaskBinding.inflate(inflater, container, false)

        binding.saveFab.setOnClickListener {
            saveTask()
        }

        return binding.root
    }

    private fun saveTask() {
        val input = binding.taskEditText.text.toString().trim()
        if (TextUtils.isEmpty(input)) {
            Snackbar.make(binding.root, "No task added.", Snackbar.LENGTH_SHORT).show()
        } else {
            val task = Task(input, false)
            viewModel.insert(task)
            navigateToTasksFragment()
        }
    }

    private fun navigateToTasksFragment() {
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.tasksFragment, true).build()
        findNavController().navigate(R.id.tasksFragment, null, navOptions)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}