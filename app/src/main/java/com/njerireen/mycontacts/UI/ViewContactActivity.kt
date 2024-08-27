package com.njerireen.mycontacts.UI

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.njerireen.mycontacts.R
import com.njerireen.mycontacts.databinding.ActivityAddContactBinding
import com.njerireen.mycontacts.databinding.ActivityViewContactBinding
import com.njerireen.mycontacts.viewModel.ContactsViewModel

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    val contactsViewModel:ContactsViewModel by viewModels()
    var contactId = 0

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){uri->
        if (uri != null) {
          Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding= ActivityViewContactBinding.inflate(layoutInflater)
            setContentView(binding.root)

            if(intent.extras!=null){
                contactId = intent.getIntExtra("CONTACT_ID", 0)
            }
            else{
                finish()
            }
        }
    override fun onResume() {
        super.onResume()
        contactsViewModel.getContactById(contactId).observe(this){
            contact->
            binding.tvContactEmail.text=contact.email
            binding.tvContactName.text=contact.name
            binding.tvContactNumber.text=contact.phoneNumber
        }
        binding.ivContactImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }

}