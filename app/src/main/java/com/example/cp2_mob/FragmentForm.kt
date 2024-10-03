package com.example.cp2_mob

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class FragmentForm : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var spinnerGender: Spinner
    private lateinit var buttonSubmit: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editTextName = view.findViewById(R.id.editTextName)
        editTextAge = view.findViewById(R.id.editTextAge)
        spinnerGender = view.findViewById(R.id.spinnerGender)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)

        // Adicionando dados ao Spinner
        val genders = arrayOf("Masculino", "Feminino", "Outro")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genders)
        spinnerGender.adapter = adapter

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString()
            val gender = spinnerGender.selectedItem.toString()

            if (name.isNotEmpty() && age.isNotEmpty()) {
                // Passar dados para DisplayFragment
                val displayFragment = FragmentDisplay.newInstance(name, age, gender)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, displayFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(requireContext(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

