package com.awalideck.tasks.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.awalideck.tasks.R
import com.awalideck.tasks.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)

        val quadNum = TasksFragmentArgs.fromBundle(requireArguments()).quadNum
        val textView = binding.quadNumber
        textView.text = "Quadrant number: $quadNum"

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