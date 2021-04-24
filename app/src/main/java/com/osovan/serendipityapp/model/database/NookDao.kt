package com.osovan.serendipityapp.model.database

import androidx.room.*

@Dao
interface NookDao {

    @Query("SELECT * FROM Nook")
    suspend fun getAll(): List<Nook>

    @Query("SELECT * FROM Nook WHERE id =:id")
    suspend fun getById(id: Int): Nook

    @Update
    suspend fun update(Nook: Nook)

    @Insert
    suspend fun insert(Nooks: List<Nook>)

    @Delete
    suspend fun delete(Nook: Nook)
}