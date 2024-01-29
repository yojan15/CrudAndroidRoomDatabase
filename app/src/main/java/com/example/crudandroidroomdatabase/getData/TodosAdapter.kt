package com.example.crudandroidroomdatabase.getData

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudandroidroomdatabase.R
import com.example.crudandroidroomdatabase.data.Todos
class TodosAdapter(private var todos: MutableList<Todos>) : RecyclerView.Adapter<TodosAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(todosView : View) : RecyclerView.ViewHolder(todosView) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosAdapter.TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item),parent,false)
        return TodoViewHolder(view)
    }
    override fun onBindViewHolder(holder: TodosAdapter.TodoViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            tvTitle.text = todos[position].text
        }
    }
    override fun getItemCount(): Int {
       return todos.size
    }
}