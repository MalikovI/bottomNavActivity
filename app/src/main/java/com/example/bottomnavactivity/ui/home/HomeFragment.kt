package com.example.bottomnavactivity.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bottomnavactivity.R
import com.example.bottomnavactivity.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
          findNavController().navigate(R.id.task_Fragment)
        }
        parentFragmentManager.setFragmentResultListener("rk_result", viewLifecycleOwner)
        { key, bundle ->
            val text = bundle.getString("text")
            Log.e("Home","onViewCreated : $text")

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}