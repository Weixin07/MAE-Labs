package com.example.lab_6

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_dialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_dialog : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_dialog, container, false)

        var btnToast = view.findViewById<Button>(R.id.buttonToast)
        btnToast.setOnClickListener {
            Toast.makeText(context, "Toast Message inside Fragment", Toast.LENGTH_SHORT).show()
        }

        var btnDialog = view.findViewById<Button>(R.id.buttonDialog)
        btnDialog.setOnClickListener {
            OverlayDialogFragment().show(childFragmentManager, OverlayDialogFragment.TAG)

        }

        var btnAlert = view.findViewById<Button>(R.id.buttonAlert)
        btnAlert.setOnClickListener {
            val myalert = AlertDialog.Builder(context)
            myalert.apply {
                setIcon(R.drawable.ic_baseline_warning_24)
                setTitle("Alert Dialog")
                setMessage("This is an alert dialog message!")
                setPositiveButton("OK") { _, _ ->
                    Toast.makeText(context, " positive / OK button clicked", Toast.LENGTH_SHORT)
                        .show()
                }
                setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(context, " Negative/Cancel button clicked", Toast.LENGTH_SHORT)
                        .show()
                }

            }.create().show()
        }

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_dialog.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_dialog().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}