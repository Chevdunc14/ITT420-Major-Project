package com.example.uccapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.uccapp.courses.CoursesActivity
import com.example.uccapp.faculty.FacultyActivity
import com.example.uccapp.social.SocialMediaActivity
import com.example.uccapp.admissions.AdmissionsActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnFaculty).setOnClickListener {
            startActivity(Intent(this, FacultyActivity::class.java))
        }

        findViewById<Button>(R.id.btnCourses).setOnClickListener {
            startActivity(Intent(this, CoursesActivity::class.java))
        }

        findViewById<Button>(R.id.btnAdmissions).setOnClickListener {
            startActivity(Intent(this, AdmissionsActivity::class.java))
        }

        findViewById<Button>(R.id.btnSocial).setOnClickListener {
            startActivity(Intent(this, SocialMediaActivity::class.java))
        }

        findViewById<FloatingActionButton>(R.id.fabEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:hod@ucc.edu.jm")
                putExtra(Intent.EXTRA_SUBJECT, "Inquiry to HOD")
            }
            startActivity(intent)
        }
    }
}
