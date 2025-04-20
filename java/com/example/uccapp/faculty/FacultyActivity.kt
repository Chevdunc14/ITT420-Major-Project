package com.example.uccapp.faculty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uccapp.databinding.ActivityFacultyBinding

class FacultyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFacultyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacultyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val facultyList = listOf(
            FacultyMember("Dr. Jane Smith", "876-555-1234", "jane.smith@ucc.edu.jm", "dr_jane.jpg"),
            FacultyMember("Prof. Martin Blake", "876-555-5678", "martin.blake@ucc.edu.jm", "prof_martin.jpg"),
            FacultyMember("Prof. Andre Brown", "876-555-3456", "Andre.brown@ucc.edu.jm", "prof_brown.jpg"),
            FacultyMember("Prof. Janet Green", "876-555-4321", "janet.green@ucc.edu.jm", "prof_janet.jpg")
        )

        binding.recyclerFaculty.layoutManager = LinearLayoutManager(this)
        binding.recyclerFaculty.adapter = FacultyAdapter(facultyList)
    }
}
