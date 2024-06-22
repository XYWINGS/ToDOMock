package com.example.testmad01.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 2)
abstract class Studentsdb : RoomDatabase(){
    abstract fun getStudentDao():StudentDao

    companion object{
        @Volatile
        private var INSTANCE: Studentsdb? = null

        fun getDatabase(context: Context): Studentsdb{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Studentsdb::class.java,"student_table"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }


    }


}