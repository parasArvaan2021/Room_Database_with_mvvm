 package com.example.roomdatabasedemo.data

import androidx.lifecycle.LiveData

class DataRecordRepository(private val datarecordDao: DataRecordDao) {

    val allItems: LiveData<List<DataRecord>> = datarecordDao.getall()

    fun get(id: Long):LiveData<DataRecord> {
        return datarecordDao.get(id)
    }

    suspend fun update(item: DataRecord) {
        datarecordDao.update(item)
    }

    suspend fun insert(item: DataRecord) {
        datarecordDao.insert(item)
    }

    suspend fun delete(item: DataRecord) {
        datarecordDao.delete(item)
    }
}