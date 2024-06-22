package com.example.testmad01

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testmad01.database.Student

class StudentViewModel(application: Application) : AndroidViewModel(application){

    private val _data = MutableLiveData<List<Student>>()

    val data: LiveData<List<Student>> = _data

    fun setData(data:List<Student>){
        _data.value = data
    }

}