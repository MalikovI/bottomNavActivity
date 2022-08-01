package com.example.bottomnavactivity.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.bottomnavactivity.databinding.FragmentProfileBinding
import com.example.bottomnavactivity.ext.loadImage

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
     private val galleryLauncher =
         registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.data != null && it.resultCode == RESULT_OK){
            val image = it?.data?.data
            binding.ivProfile.loadImage(image)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProfileBinding.inflate(
            LayoutInflater.from(requireContext()),container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivProfile.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
           galleryLauncher.launch(intent)
        }
    }
}