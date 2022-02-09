package com.example.dialogs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogs.R
import com.example.dialogs.databinding.CustomDialogItem2Binding
import com.example.dialogs.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentSecondBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.customDialog2.setOnClickListener {
            val customDialog = AlertDialog.Builder(requireActivity()).create()
            val bindingDialog = CustomDialogItem2Binding.inflate(layoutInflater)
            customDialog.setView(bindingDialog.root)
            customDialog.setCancelable(true)

            customDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            bindingDialog.cancel.setOnClickListener {
                Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }

            bindingDialog.retry.setOnClickListener {
                Toast.makeText(requireActivity(), "Retrying", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }

            customDialog.show()
        }
    }
}