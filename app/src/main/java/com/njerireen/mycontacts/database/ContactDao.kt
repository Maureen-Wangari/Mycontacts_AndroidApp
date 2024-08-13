package com.njerireen.mycontacts.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.njerireen.mycontacts.model.Contact


@Dao
interface ContactDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM Contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
    fun getContactById(contactId: Int): LiveData<Contact>

    @Update
    fun updateContact(contact:Contact)

    @Delete
    fun deletingContact(contact: Contact)
}
