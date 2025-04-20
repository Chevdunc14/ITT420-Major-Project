package com.example.uccapp.courses

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues

class CourseDatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object {
        private const val DATABASE_NAME = "courses.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "courses"
        const val COLUMN_ID = "id"
        const val COLUMN_CODE = "course_code"
        const val COLUMN_NAME = "course_name"
        const val COLUMN_CREDITS = "credits"
        const val COLUMN_PREREQUISITES = "prerequisites"
        const val COLUMN_DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_CODE TEXT,
                $COLUMN_NAME TEXT,
                $COLUMN_CREDITS INTEGER,
                $COLUMN_PREREQUISITES TEXT,
                $COLUMN_DESCRIPTION TEXT
            )
        """.trimIndent()

        db.execSQL(createTable)
        insertDefaultCourses(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    private fun insertDefaultCourses(db: SQLiteDatabase) {
        val courses = listOf(
            Course(0, "ITT1001", "IT Essentials", 3, "None", "Fundamentals of IT and computing."),
            Course(0, "ITT1002", "Networking Principles", 3, "ITT1001", "Covers basic network principles."),
            Course(0, "ITT2001", "Database Systems", 3, "ITT1001", "Relational DBs and SQL."),
            Course(0, "ITT2002", "Internet Authoring", 3, "ITT1001", "HTML, CSS, JS basics."),
            Course(0, "ITT2003", "Programming I", 3, "None", "Intro to structured programming."),
            Course(0, "ITT2004", "Programming Using C#", 3, "ITT2003", "Programming using C#."),
            Course(0, "ITT3001", "Mobile Application Development", 3, "ITT2004", "Android app development."),
            Course(0, "ITT3002", "Cybersecurity", 3, "ITT1002", "Security threats and defense."),
            Course(0, "ITT4001", "Cloud Computing", 3, "ITT2001", "Virtualization and cloud tools."),
            Course(0, "ITT4002", "Capstone Project", 6, "All core courses", "Final practical project.")
        )

        for (course in courses) {
            val values = ContentValues().apply {
                put(COLUMN_CODE, course.code)
                put(COLUMN_NAME, course.name)
                put(COLUMN_CREDITS, course.credits)
                put(COLUMN_PREREQUISITES, course.prerequisites)
                put(COLUMN_DESCRIPTION, course.description)
            }
            db.insert(TABLE_NAME, null, values)
        }
    }

    fun getAllCourses(): List<Course> {
        val courseList = mutableListOf<Course>()
        val db = readableDatabase
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                courseList.add(
                    Course(
                        id = getInt(getColumnIndexOrThrow(COLUMN_ID)),
                        code = getString(getColumnIndexOrThrow(COLUMN_CODE)),
                        name = getString(getColumnIndexOrThrow(COLUMN_NAME)),
                        credits = getInt(getColumnIndexOrThrow(COLUMN_CREDITS)),
                        prerequisites = getString(getColumnIndexOrThrow(COLUMN_PREREQUISITES)),
                        description = getString(getColumnIndexOrThrow(COLUMN_DESCRIPTION))
                    )
                )
            }
            close()
        }

        return courseList
    }
}
