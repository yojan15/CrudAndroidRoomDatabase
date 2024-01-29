package com.example.crudandroidroomdatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudandroidroomdatabase.data.TodosDatabase
import com.example.crudandroidroomdatabase.databinding.ActivityGetAllDataBinding
import com.example.crudandroidroomdatabase.getData.TodosAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityGetAllData : AppCompatActivity() {
    private lateinit var binding : ActivityGetAllDataBinding
    private lateinit var database : TodosDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetAllDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = TodosDatabase.getDatabase(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        GlobalScope.launch {
            Log.e("MainActivity","getData")
            binding.recyclerView.adapter = TodosAdapter(database.todosDao().getAll())
        }
    }
}