package com.example.uccapp.courses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uccapp.databinding.ActivityCoursesBinding

class CoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoursesBinding
    private lateinit var courseAdapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = CourseDatabaseHelper(this)
        val courseList = dbHelper.getAllCourses()

        courseAdapter = CourseAdapter(courseList)

        binding.recyclerCourses.apply {
            layoutManager = LinearLayoutManager(this@CoursesActivity)
            adapter = courseAdapter
        }
    }
}
