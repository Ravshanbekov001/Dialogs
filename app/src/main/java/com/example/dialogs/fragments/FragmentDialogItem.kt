package com.example.dialogs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dialogs.R
import com.example.dialogs.databinding.FragmentDialogItemBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentDialogItem : DialogFragment() {

    lateinit var binding: FragmentDialogItemBinding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDialogItemBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancel3.setOnClickListener {
            Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.submit.setOnClickListener {

            if (binding.java.isChecked) {
                Toast.makeText(requireActivity(), "Submitted Java", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            if (binding.kotlin.isChecked) {
                Toast.makeText(requireActivity(), "Submitted Kotlin", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            if (binding.swift.isChecked) {
                Toast.makeText(requireActivity(), "Submitted Swift", Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentDialogItem().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}