package com.njerireen.mycontacts.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.njerireen.mycontacts.model.Contact
import com.njerireen.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        displayContacts()

    }

    fun displayContacts(){
        val contact1 = Contact("Maureen", "0715775485","njeri@gmail.com","")
        val contact2 = Contact("Sharon", "0714775485","shazzy@gmail.com","")
        val contact3 = Contact("Martha", "0713775485","mongeli@gmail.com","")
        val contact4 = Contact("Lau", "0712775485","laura@gmail.com","")
        val contact5 = Contact("Wanjoix", "0711775485","wanjoix@gmail.com","")
        val contact6 = Contact("Blondie", "0710775485","debz@gmail.com","")
        val contact7 = Contact("Kinuthia", "0709775485","essie@gmail.com","")
        val contact8 = Contact("Kuria", "0708775485","kuria@gmail.com","")
        val contact9 = Contact("Samidoo", "0707775485","samsam@gmail.com","")

        val contactList = listOf(contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8, contact9)
        val contactsAdapter = ContactsAdapter(contactList)
        binding.rvContacts.adapter= contactsAdapter
    }
    }