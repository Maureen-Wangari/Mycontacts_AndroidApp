package com.njerireen.mycontacts.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.njerireen.mycontacts.model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)

abstract class ContactsDataBase: RoomDatabase() {

    abstract fun getContactDao(): ContactDao

    companion object{
        private var database: ContactsDataBase? = null

        fun  getDataBase(context: Context): ContactsDataBase{
            if(database==null){
                database = Room
                    .databaseBuilder(context,ContactsDataBase::class.java, name = "contacts_db")
                    .build()
            }
            return database as ContactsDataBase
        }
    }
}
