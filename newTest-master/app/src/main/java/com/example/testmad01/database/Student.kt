package com.example.testmad01.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student_table")
data class Student(
    var SID : String,
    var name : String,
    var age : String,
    var faculty : String,
    var year : String,
    var GPA : String
  //  var semester : Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int?= null
}
