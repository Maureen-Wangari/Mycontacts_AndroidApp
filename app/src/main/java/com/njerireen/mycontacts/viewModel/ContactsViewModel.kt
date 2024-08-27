package com.njerireen.mycontacts.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njerireen.mycontacts.Repository.ContactsRepository
import com.njerireen.mycontacts.model.Contact
import kotlinx.coroutines.launch

class ContactsViewModel: ViewModel() {
    val contactsRepository = ContactsRepository()
    fun  saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
    fun getAllContacts():LiveData<List<Contact>>{
        return  contactsRepository.getAllContacts()
    }
}