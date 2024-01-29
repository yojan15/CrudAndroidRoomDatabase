package com.example.crudandroidroomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todos::class] , version = 1)
abstract class TodosDatabase : RoomDatabase() {

    abstract fun todosDao() : TodosDao
    companion object {
        @Volatile
        private var INSTANCE : TodosDatabase? = null
        fun getDatabase(context : Context):TodosDatabase {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TodosDatabase::class.java,
                        "todosDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}