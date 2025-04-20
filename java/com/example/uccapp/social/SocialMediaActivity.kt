package com.example.uccapp.social

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uccapp.databinding.ActivitySocialMediaBinding

class SocialMediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySocialMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySocialMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/uccjamaica")
        }

        binding.btnTwitter.setOnClickListener {
            openUrl("https://twitter.com/uccjamaica")
        }

        binding.btnYoutube.setOnClickListener {
            openUrl("https://www.youtube.com/user/uccjamaica")
        }

        binding.btnTiktok.setOnClickListener {
            openUrl("https://www.tiktok.com/@uccjamaica")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
