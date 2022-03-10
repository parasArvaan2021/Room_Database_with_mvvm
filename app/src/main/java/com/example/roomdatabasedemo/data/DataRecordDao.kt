 package com.example.roomdatabasedemo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataRecordDao {

    @Query("SELECT * from datarecords")
    fun getall(): LiveData<List<DataRecord>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(item: DataRecord)

    @Query("SELECT * FROM datarecords WHERE datarecords.id == :id")
    fun get(id: Long): LiveData<DataRecord>

    @Update
    suspend fun update(vararg items: DataRecord)

    @Delete
    suspend fun delete(vararg items: DataRecord)
}