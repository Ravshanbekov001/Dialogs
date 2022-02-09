package com.example.dialogs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogs.R
import com.example.dialogs.databinding.CustomDialogItem3Binding
import com.example.dialogs.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentThirdBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.customDialog3.setOnClickListener {
            val customDialog = AlertDialog.Builder(requireActivity()).create()
            val bindingDialog = CustomDialogItem3Binding.inflate(layoutInflater)
            customDialog.setView(bindingDialog.root)
            customDialog.setCancelable(true)

            bindingDialog.okay.setOnClickListener {
                Toast.makeText(requireActivity(), "Okay", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }

            bindingDialog.cancel2.setOnClickListener {
                Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }

            customDialog.show()
        }
    }
}