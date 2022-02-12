package com.fragment.communication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fragment.communication.R
import com.fragment.communication.databinding.FragmentCommunicationActivityBinding
import com.fragment.communication.fragment.ReceiverFragment
import com.fragment.communication.fragment.SenderFragment

class FragmentCommunicationActivity : AppCompatActivity() {

    private lateinit var fragmentCommunicationActivity: FragmentCommunicationActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentCommunicationActivity = FragmentCommunicationActivityBinding.inflate(layoutInflater)
        setContentView(fragmentCommunicationActivity.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.sender_fragment, SenderFragment())
            .add(R.id.receiver_fragment, ReceiverFragment())
            .commit()
    }
}