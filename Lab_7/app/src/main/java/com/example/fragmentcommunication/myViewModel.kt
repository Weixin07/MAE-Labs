package com.example.fragmentcommunication

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class myViewModel :ViewModel(){

    private val TAG = myViewModel::class.java.simpleName
    private var CountryList: MutableLiveData<List<String>>? = null

    fun getCountryList(): LiveData<List<String>> {
        if (CountryList == null) {
            CountryList = MutableLiveData<List<String>>()
            loadData()
        }
        return CountryList as LiveData<List<String>>
    }

    fun addCountry(name: String) {
        var temp : MutableList<String> = CountryList?.value as MutableList<String>
        temp.add(name)
        CountryList!!.setValue(temp)
    }
    private fun loadData() {
        // do async operation to fetch users
        val myHandler = Handler()
        myHandler.postDelayed({
            val countryList: MutableList<String> = ArrayList()
            countryList.add("Malaysia")
            countryList.add("Indonesia")
            countryList.add("Thailand")
            countryList.add("China")
            countryList.add("Myanmar")
            countryList.add("Yemen")
            countryList.add("UAE")
            countryList.add("South Africa")
            countryList.add("Yemen")
            CountryList!!.setValue(countryList)
        }, 2000)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "on cleared called")
    }
}
