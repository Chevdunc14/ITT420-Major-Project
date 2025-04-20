package com.example.uccapp.courses

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uccapp.databinding.ItemCourseBinding
import com.example.uccapp.R

class CourseAdapter(private val courseList: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        with(holder.binding) {
            txtCourseCode.text = course.code
            txtCourseName.text = course.name
            txtCourseCredits.text = root.context.getString(R.string.course_credits, course.credits)
            txtCoursePrereqs.text = root.context.getString(R.string.course_prerequisite, course.prerequisites)
            txtCourseDesc.text = course.description

            root.setOnClickListener {
                val context = it.context
                val intent = Intent(context, CourseDetailActivity::class.java).apply {
                    putExtra("name", course.name)
                    putExtra("code", course.code)
                    putExtra("credits", course.credits)
                    putExtra("prerequisites", course.prerequisites)
                    putExtra("description", course.description)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = courseList.size
}
