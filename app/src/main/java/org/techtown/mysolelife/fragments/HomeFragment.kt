package org.techtown.mysolelife.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.techtown.mysolelife.R
import org.techtown.mysolelife.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.tipTab.setOnClickListener {
            Log.d("tiptab","tiptab")
            it.findNavController().navigate(R.id.action_homeFragment2_to_tipFragment)
        }
        binding.talkTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_talkFragment)
        }
        binding.bookmarkTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_bookmarkFragment)
        }
        binding.storeTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_storeFragment)
        }


        return binding.root
    }


}