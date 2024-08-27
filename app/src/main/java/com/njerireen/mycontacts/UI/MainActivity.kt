package com.njerireen.mycontacts.UI

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.njerireen.mycontacts.model.Contact
import com.njerireen.mycontacts.databinding.ActivityMainBinding
import com.njerireen.mycontacts.viewModel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        binding.fabAddContacts.setOnClickListener {startActivity(Intent(this,AddContactActivity::class.java))}
        contactsViewModel.getAllContacts().observe(this){contactList->
            displayContacts(contactList)
        }

        binding
    }

    fun displayContacts(contactList: List<Contact>){

        val contactsAdapter = ContactsAdapter(contactList, this)
        binding.rvContacts.adapter= contactsAdapter
    }
    }