package com.example.crudandroidroomdatabase.data
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Todos(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String
)
