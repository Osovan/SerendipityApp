package com.osovan.serendipityapp.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Nook::class], version = 1)
abstract class NookDatabase : RoomDatabase() {

    abstract fun nookDao(): NookDao


    companion object {

        private var INSTANCE: NookDatabase? = null

        fun getInstance(context: Context): NookDatabase {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NookDatabase::class.java,
                    "nooksDB"
                ).build()
            }
            return INSTANCE!!
        }

    }
}