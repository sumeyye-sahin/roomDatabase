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

        // ViewModel'ı oluşturun
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Kaydet düğmesine tıklama olayı ekleyin
        binding.button.setOnClickListener {
            val firstName = binding.editTextText.text.toString()
            val lastName = binding.editTextText2.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                // ViewModel aracılığıyla veritabanına kullanıcı ekleyin
                userViewModel.insertUser(firstName, lastName)

                // Giriş alanlarını temizleyin
                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()
            }
        }

        // Kullanıcıları listeleyen bir düğme veya başlangıçta otomatik olarak kullanıcıları alabilirsiniz.
        // Örneğin:
        // btnListUsers.setOnClickListener {
        //     userViewModel.getAllUsers().observe(this, { users ->
        //         // Kullanıcıları işleyin ve görüntüleyin
        //     })
        // }
    }
}