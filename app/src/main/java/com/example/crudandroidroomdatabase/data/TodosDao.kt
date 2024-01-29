package com.example.crudandroidroomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodosDao {
    @Insert
    fun insertTodos(todos: Todos)
    @Update
    fun updateTodos(todos: Todos)
    @Delete
    fun deleteTodos(todos: Todos)
    @Query("select * from todos order by id ASC")
    fun getAll() : MutableList<Todos>
}