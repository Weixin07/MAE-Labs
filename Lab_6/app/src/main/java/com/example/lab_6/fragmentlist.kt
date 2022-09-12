package com.example.lab_6

import android.app.ListFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast

@Suppress("DEPRECATION")
class fragmentlist : ListFragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var listview = listView
        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(activity, listview.getItemAtPosition(position) as CharSequence?, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val listOfCountry = resources.getStringArray(R.array.countrylist)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(activity, R.layout.fragment_list_item, R.id.textViewName, listOfCountry)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance() : ListFragment {
            return fragmentlist()
        }
    }
}
