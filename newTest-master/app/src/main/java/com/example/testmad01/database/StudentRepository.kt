package com.example.testmad01.database

import androidx.lifecycle.LiveData

class StudentRepository(private val db : Studentsdb){

  // val readAllData : LiveData<List<Student>> = studentDao.getAllStudents()
//    suspend fun addStudent(student: Student){ studentDao.addStudent(student) }
//
//    suspend fun insert(student: Student) = db.getTodoDao().insert(todo)
//    suspend fun delete(student: Student) = db.getTodoDao().delete(todo)
//    fun getAllTodoItems():List<Student> = db.getTodoDao().getAllTodoItems()


  suspend fun insert(student: Student) = db.getStudentDao().insert(student)
  suspend fun delete(student: Student) = db.getStudentDao().delete(student)
  fun getAllTodoItems():List<Student> = db.getStudentDao().getAllStudents()




}