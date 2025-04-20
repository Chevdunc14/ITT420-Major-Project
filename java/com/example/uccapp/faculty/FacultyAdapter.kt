package com.example.uccapp.faculty

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.uccapp.databinding.ItemFacultyBinding

class FacultyAdapter(private val facultyList: List<FacultyMember>) :
    RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    inner class FacultyViewHolder(val binding: ItemFacultyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val binding = ItemFacultyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacultyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val member = facultyList[position]
        with(holder.binding) {
            txtName.text = member.name
            txtPhone.text = member.phone
            txtEmail.text = member.email

            try {
                val inputStream = root.context.assets.open(member.imageFileName)
                val drawable = Drawable.createFromStream(inputStream, null)
                imgProfile.setImageDrawable(drawable)
            } catch (e: Exception) {
                imgProfile.setImageDrawable(null)
            }

            imgEmail.setOnClickListener {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${member.email}")
                    putExtra(Intent.EXTRA_SUBJECT, "Inquiry from UCC App")
                }
                try {
                    root.context.startActivity(emailIntent)
                } catch (e: Exception) {
                    Toast.makeText(root.context, "No email app found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = facultyList.size
}