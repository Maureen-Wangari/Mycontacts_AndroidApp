package com.njerireen.mycontacts.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.njerireen.mycontacts.model.Contact
import com.njerireen.mycontacts.databinding.ContactListItemBinding

data class ContactsAdapter(var contactsList: List<Contact>):
        RecyclerView.Adapter<ContactsViewHolder>(
        ){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
       val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvEmail.text = contact.email
        holder.binding.tvPhoneNumber.text = contact.phoneNumber
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}
class ContactsViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){

}
//val  tvName = itemView.findViewById<TextView>(R.id.tvName)
//    val  tvPhoneNumber = itemView.findViewById<TextView>(R.id.tvPhoneNumber)
//    val  tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)