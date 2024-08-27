package com.njerireen.mycontacts.UI

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.njerireen.mycontacts.model.Contact
import com.njerireen.mycontacts.databinding.ContactListItemBinding

data class ContactsAdapter(var contactsList: List<Contact>,val context:Context):
        RecyclerView.Adapter<ContactsViewHolder>(
        ){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
       val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ContactsViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvEmail.text = contact.email
        holder.binding.tvPhoneNumber.text = contact.phoneNumber
        holder.binding.cvContacts.setOnClickListener {
            val intent = Intent(context,ViewContactActivity::class.java)
            intent.putExtra("CONTACT_ID",contact.contactId)
            context.startActivity(intent)
        }
    }

}
class ContactsViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){

}
//val  tvName = itemView.findViewById<TextView>(R.id.tvName)
//    val  tvPhoneNumber = itemView.findViewById<TextView>(R.id.tvPhoneNumber)
//    val  tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)