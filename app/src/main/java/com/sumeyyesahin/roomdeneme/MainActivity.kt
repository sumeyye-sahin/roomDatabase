package com.sumeyyesahin.roomdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sumeyyesahin.roomdeneme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

      
        binding.button.setOnClickListener {
            val firstName = binding.editTextText.text.toString()
            val lastName = binding.editTextText2.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
              
                userViewModel.insertUser(firstName, lastName)

                
                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()
            }
        }

        
    
    }
}
