package com.njerireen.mycontacts.Repository

import androidx.lifecycle.LiveData
import com.njerireen.mycontacts.database.ContactsDataBase
import com.njerireen.mycontacts.model.Contact
import com.njerireen.mycontacts.viewModel.ContactsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ContactsRepository {
    val dataBase = ContactsDataBase.getDataBase(ContactsApp.appContext)

    suspend fun saveContact(contact: Contact){
        withContext(Dispatchers.IO){
            dataBase.getContactDao().insertContact(contact)
        }
    }
    fun getAllContacts():LiveData<List<Contact>>{
        return  dataBase.getContactDao().getAllContacts()
    }
}