package com.example.uccapp.courses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uccapp.databinding.ActivityCourseDetailBinding

class CourseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseName = intent.getStringExtra("name") ?: "N/A"
        val courseCode = intent.getStringExtra("code") ?: "N/A"
        val courseCredits = intent.getIntExtra("credits", 0)
        val coursePrereqs = intent.getStringExtra("prerequisites") ?: "None"
        val courseDesc = intent.getStringExtra("description") ?: "No description available"

        binding.txtDetailName.text = courseName
        binding.txtDetailCode.text = courseCode
        binding.txtDetailCredits.text = "Credits: $courseCredits"
        binding.txtDetailPrereqs.text = "Prerequisite: $coursePrereqs"
        binding.txtDetailDescription.text = courseDesc
    }
}
