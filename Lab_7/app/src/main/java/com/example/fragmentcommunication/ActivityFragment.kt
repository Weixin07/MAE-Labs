package com.example.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.appcompat.app.AppCompatActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivityFragment : AppCompatActivity(), FragmentCommunicator {
    private lateinit var currentFragment : Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)

        currentFragment = NestedFragment()
        supportFragmentManager.beginTransaction().replace(R.id.constraintLayoutFragment, currentFragment)
            .commit()
    }


    override fun passData(text: String) {
        val bundle = Bundle()
        bundle.putString("data1", text)
        val transaction = this.supportFragmentManager.beginTransaction()
        val nextFrag = NestedFragmentB()
        nextFrag.arguments = bundle
        transaction.replace(R.id.constraintLayoutFragment, nextFrag)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()

    }

}
