package com.example.testmad01.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun addStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun getAllStudents():List<Student>

    @Insert
    suspend fun insert(student: Student)
    @Delete
    suspend fun delete(student: Student)




}