package com.example.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class NestedFragment : Fragment() {
    var communicator: FragmentCommunicator? = null
    var editTextmessage : EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_nested, container, false)
        editTextmessage = view.findViewById<EditText>(R.id.editTextMessage)
        var btnPassToFragment = view.findViewById<Button>(R.id.buttonPassToFragment)

        communicator = context as FragmentCommunicator

        btnPassToFragment.setOnClickListener {
            communicator?.passData(editTextmessage?.text.toString())
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        communicator = null
    }


    companion object {
        @JvmStatic
        fun newInstance() : NestedFragment {
            return NestedFragment()
        }
    }


}
