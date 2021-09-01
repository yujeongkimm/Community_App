package org.techtown.mysolelife.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.techtown.mysolelife.R
import org.techtown.mysolelife.databinding.FragmentStoreBinding
import org.techtown.mysolelife.databinding.FragmentTalkBinding


class TalkFragment : Fragment() {

    private lateinit var binding : FragmentTalkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)

        binding.homeTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment2)
        }
        binding.tipTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }
        binding.storeTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }
        binding.bookmarkTab.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }

        return binding.root
    }


}