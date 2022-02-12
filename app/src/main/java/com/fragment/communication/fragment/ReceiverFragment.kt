package com.fragment.communication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.fragment.communication.databinding.ReceiverFragmentBinding
import com.fragment.communication.viewmodel.SharedViewModel

class ReceiverFragment : Fragment() {
    private lateinit var receiverFragmentBinding: ReceiverFragmentBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        receiverFragmentBinding = ReceiverFragmentBinding.inflate(inflater, container, false)
        return receiverFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProviders.of(requireActivity()).get(
            SharedViewModel::class.java
        )

        //send data from receiver to sender
        receiverFragmentBinding.buttonReceiver.setOnClickListener {
            receiverFragmentBinding.editTextReceiver.text?.let { it ->
                sharedViewModel.setReceiverData(it)
            }

            receiverFragmentBinding.editTextReceiver.text!!.clear()
        }

        //get & bind data from sender to receiver
        sharedViewModel.getSenderData().observe(viewLifecycleOwner, {
            receiverFragmentBinding.textViewReceiverData.text = it.toString()
        })
    }

}