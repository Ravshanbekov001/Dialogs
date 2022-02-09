package com.example.dialogs.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.dialogs.R
import com.example.dialogs.databinding.BottomSheetDialogItemBinding
import com.example.dialogs.databinding.CustomDialogItemBinding
import com.example.dialogs.databinding.FragmentFirstBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

class FirstFragment : DialogFragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentFirstBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.alertDialog.setOnClickListener {

            val alertDialog = AlertDialog.Builder(requireActivity())
            alertDialog.setTitle("Alert Dialog Title")
            alertDialog.setMessage("Alert Dialog message")

            alertDialog.setCancelable(false)

            alertDialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(requireActivity(), "Yes", Toast.LENGTH_SHORT).show()
                }
            })

            alertDialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(requireActivity(), "No", Toast.LENGTH_SHORT).show()
                }
            })

            alertDialog.setNeutralButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_SHORT).show()
                }
            })

            alertDialog.show()
        }


        binding.customDialog.setOnClickListener {
            val customDialog = AlertDialog.Builder(requireActivity()).create()
            val bindingDialog = CustomDialogItemBinding.inflate(layoutInflater)
            customDialog.setView(bindingDialog.root)
            customDialog.setCancelable(true)

            customDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            bindingDialog.save.setOnClickListener {
                Toast.makeText(requireActivity(), "Saved", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }

            customDialog.show()
        }


        binding.fragmentDialog.setOnClickListener {
            val fragmentDialog = FragmentDialogItem.newInstance("", "")
//            fragmentDialog.requireActivity().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            fragmentDialog.show(parentFragmentManager.beginTransaction(), "")



        }


        binding.datePickerDialog.setOnClickListener {
            val datePickerDialog = DatePickerDialog(requireActivity())
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(requireActivity(),
                    "${dayOfMonth}.${month + 1}.$year",
                    Toast.LENGTH_SHORT)
                    .show()
            }
            datePickerDialog.show()
        }


        binding.timePickerDialog.setOnClickListener {
            val timePickerDialog =
                TimePickerDialog(requireActivity(),
                    { view, hourOfDay, minute ->
                        Toast.makeText(requireActivity(), "$hourOfDay:$minute", Toast.LENGTH_SHORT)
                            .show()
                    }, 24, 60, true)

            timePickerDialog.show()
        }


        binding.bottomSheetDialog.setOnClickListener {
            val bottomSheetDialog =
                BottomSheetDialog(requireActivity(), R.style.BottomSheetDialogTheme)

            val bindingDialog = BottomSheetDialogItemBinding.inflate(layoutInflater)

            bottomSheetDialog.setContentView(bindingDialog.root)

            bindingDialog.yoping.setOnClickListener {
                Toast.makeText(requireActivity(), "Hayr!", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.show()
        }


        binding.snackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "Snackbar title", Snackbar.LENGTH_LONG)

            snackbar.setAction("Click") {
                Toast.makeText(requireActivity(),
                    "Clicked",
                    Toast.LENGTH_SHORT).show()
            }

            snackbar.show()
        }
    }
}