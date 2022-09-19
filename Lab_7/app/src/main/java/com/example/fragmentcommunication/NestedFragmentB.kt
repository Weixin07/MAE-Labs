package com.example.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class NestedFragmentB : Fragment() {
    private var param1: String? = null
    var editTextChildMsg : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("data1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_nested_b, container, false)

        editTextChildMsg = view.findViewById<EditText>(R.id.editTextChildMessage)
        editTextChildMsg?.setText(param1)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() : NestedFragmentB {
            return NestedFragmentB()
        }
    }
}
