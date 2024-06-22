package com.example.testmad01

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testmad01.database.Student
import com.example.testmad01.database.StudentRepository
import com.example.testmad01.database.Studentsdb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Integer.parseInt


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: StudentViewModel
    private lateinit var viewModel:MainActivityData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        val submitBtn: Button = view.findViewById(R.id.submitDataBtn)
        val sidET : EditText= view.findViewById(R.id.addSid)
        val addNameET : EditText= view.findViewById(R.id.addName)
        val addFacET : EditText= view.findViewById(R.id.addFaculty)
        val addAgeET : EditText= view.findViewById(R.id.addAge)
        val addYearET : EditText= view.findViewById(R.id.addYear)
        val addGPAET  : EditText= view.findViewById(R.id.addgpa)

        mUserViewModel = ViewModelProvider(this)[StudentViewModel::class.java]
        viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        val repository = StudentRepository(Studentsdb.getDatabase(requireContext()))

        submitBtn.setOnClickListener{


            val sidETs = sidET.text.toString()
            val addNameETs  = addNameET.text.toString()
            val addFacETs = addFacET.text.toString()
            val addAgeETs = addAgeET.text.toString()
            val addYearETs = addYearET.text.toString()
            val addGPAETs =addGPAET.text.toString()


            if (!areFieldsNullOrEmpty(sidETs,addNameETs,addFacETs,addAgeETs,addYearETs,addGPAETs)){

                CoroutineScope(Dispatchers.IO).launch {

                        repository.insert(
                            Student(sidETs,addNameETs,addFacETs,addAgeETs,addYearETs,addGPAETs)
                        )

                        val data = repository.getAllTodoItems()
                        requireActivity().runOnUiThread {
                            viewModel.setData(data)


                            val sidETs = sidET.text.clear()
                            val addNameETs = addNameET.text.clear()
                            val addFacETs = addFacET.text.clear()
                            val addAgeETs = addAgeET.text.clear()
                            val addYearETs = addYearET.text.clear()
                            val addGPAETs = addGPAET.text.clear()

                            Toast.makeText(
                                context,
                                "Data Inserted Successfully ",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                }
                }
            }

        return view
    }

            private  fun areFieldsNullOrEmpty(
                sidETs: String?,
                addNameETs: String?,
                addFacETs: String?,
                addAgeETs: String?,
                addYearETs: String?,
                addGPAETs: String?
            ): Boolean {
                return sidETs.isNullOrBlank() ||
                    addNameETs.isNullOrBlank() ||
                    addFacETs.isNullOrBlank() ||
                    addAgeETs.isNullOrBlank() ||
                addYearETs.isNullOrBlank() ||
                addGPAETs.isNullOrBlank()
    }


}