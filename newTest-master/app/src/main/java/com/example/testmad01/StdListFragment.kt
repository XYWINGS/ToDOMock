package com.example.testmad01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testmad01.database.StudentRepository
import com.example.testmad01.database.Studentsdb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StdListFragment : Fragment() {

    private lateinit var adapter: StudentAdaptor
    private lateinit var viewModel:MainActivityData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_std_list, container, false)
        val button: Button = view.findViewById(R.id.btnadd)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_stdListFragment_to_addFragment)
        }


//        recyclerViewShowData

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewShowData)

        val repository = StudentRepository(Studentsdb.getDatabase(requireContext()))

        viewModel = ViewModelProvider(requireActivity())[MainActivityData::class.java]


        viewModel.data.observe(requireActivity()){
            requireActivity().runOnUiThread {
                adapter = StudentAdaptor(it, repository, viewModel)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(context)
            }
        }


        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllTodoItems()
            requireActivity().runOnUiThread {
                viewModel.setData(data)

            }
        }


        return view
    }
}