package com.fragment.communication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val senderData = MutableLiveData<CharSequence>()
    private val receiverData = MutableLiveData<CharSequence>()

    fun setSenderData(charSequence: CharSequence) {
        senderData.value = charSequence
    }

    fun getSenderData(): LiveData<CharSequence> {
        return senderData
    }

    fun setReceiverData(charSequence: CharSequence) {
        receiverData.value = charSequence
    }

    fun getReceiverData(): LiveData<CharSequence> {
        return receiverData
    }

}
