package com.njerireen.mycontacts.model

import androidx.room.Entity

@Entity(tableName = "Contacts")
data class Contact(
    var contactId:Int,
    var name: String,
    var phoneNumber: String,
    var email: String,
    var avatar: String
)
