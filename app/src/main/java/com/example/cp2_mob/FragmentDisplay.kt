package com.example.cp2_mob

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FragmentDisplay : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewAge: TextView
    private lateinit var textViewGender: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textViewName = view.findViewById(R.id.textViewName)
        textViewAge = view.findViewById(R.id.textViewAge)
        textViewGender = view.findViewById(R.id.textViewGender)

        val name = arguments?.getString(ARG_NAME)
        val age = arguments?.getString(ARG_AGE)
        val gender = arguments?.getString(ARG_GENDER)

        textViewName.text = name
        textViewAge.text = age
        textViewGender.text = gender
    }

    companion object {
        private const val ARG_NAME = "name"
        private const val ARG_AGE = "age"
        private const val ARG_GENDER = "gender"

        fun newInstance(name: String, age: String, gender: String) =
            FragmentDisplay().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_AGE, age)
                    putString(ARG_GENDER, gender)
                }
            }
    }
}
