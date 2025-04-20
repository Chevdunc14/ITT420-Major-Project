package com.example.uccapp.admissions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uccapp.databinding.ActivityAdmissionsBinding

class AdmissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdmissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdmissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button to open UCC admissions website
        binding.btnApplyNow.setOnClickListener {
            val url = "https://www.ucc.edu.jm/admissions"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
