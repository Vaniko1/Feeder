package com.example.spoty.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.spoty.R
import kotlin.contracts.contract

class CustomDialogFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancButt = view.findViewById<Button>(R.id.cancButt)
        val submitButt = view.findViewById<Button>(R.id.submitButt)

        val excellentRadioButton = view.findViewById<CheckBox>(R.id.excellentRadioButton)
        val goodRadioButton = view.findViewById<CheckBox>(R.id.goodRadioButton)
        val poorRadioButton = view.findViewById<CheckBox>(R.id.poorRadioButton)

        submitButt.setOnClickListener {
            if (excellentRadioButton.isChecked && goodRadioButton.isChecked) {
                Toast.makeText(context, "Please choose only one answer", Toast.LENGTH_SHORT).show()
            } else if (excellentRadioButton.isChecked && poorRadioButton.isChecked) {
                Toast.makeText(context, "Please choose only one answer", Toast.LENGTH_SHORT).show()
            } else if (goodRadioButton.isChecked && poorRadioButton.isChecked) {
                Toast.makeText(context, "Please choose only one answer", Toast.LENGTH_SHORT).show()
            } else if(excellentRadioButton.isChecked){
                Toast.makeText(context, "You rated excellent!", Toast.LENGTH_SHORT).show()
            }else if(goodRadioButton.isChecked){
                Toast.makeText(context, "You rated good!", Toast.LENGTH_SHORT).show()
            }else if(poorRadioButton.isChecked){
                Toast.makeText(context, "You rated poor!", Toast.LENGTH_SHORT).show()
            }
            dismiss()
        }
        cancButt.setOnClickListener {
            dismiss()
        }
    }
}