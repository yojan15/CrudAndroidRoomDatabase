package com.example.crudandroidroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crudandroidroomdatabase.data.Todos
import com.example.crudandroidroomdatabase.data.TodosDatabase
import com.example.crudandroidroomdatabase.databinding.ActivityInsertBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InsertActivity : AppCompatActivity() {
    private lateinit var database: TodosDatabase
    private lateinit var binding: ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = TodosDatabase.getDatabase(this)
        binding.insertData.setOnClickListener {
            val insertText = binding.insertText.text.toString()

            if(insertText.isNotBlank()) {
                GlobalScope.launch {
                    database.todosDao().insertTodos(Todos(0,insertText))
                    binding.insertText.text.clear()
                    Toast.makeText(this@InsertActivity,"Record inserted",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}