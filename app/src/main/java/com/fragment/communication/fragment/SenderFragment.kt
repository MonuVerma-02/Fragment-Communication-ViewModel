package com.fragment.communication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.fragment.communication.databinding.SenderFragmentBinding
import com.fragment.communication.viewmodel.SharedViewModel

class SenderFragment : Fragment() {
    private lateinit var senderFragmentBinding: SenderFragmentBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        senderFragmentBinding = SenderFragmentBinding.inflate(inflater, container, false)
        return senderFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProviders.of(requireActivity()).get(
            SharedViewModel::class.java
        )

        //send data from sender to receiver
        senderFragmentBinding.buttonSender.setOnClickListener {
            senderFragmentBinding.editTextSender.text?.let { it ->
                sharedViewModel.setSenderData(it)
            }

            senderFragmentBinding.editTextSender.text!!.clear()
        }

        //get & bind data from receiver to sender
        sharedViewModel.getReceiverData().observe(viewLifecycleOwner, {
            senderFragmentBinding.textViewSenderData.text = it
        })
    }
}