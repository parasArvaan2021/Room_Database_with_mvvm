 package com.example.roomdatabasedemo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasedemo.data.AppRoomDatabase
import com.example.roomdatabasedemo.data.DataRecord
import com.example.roomdatabasedemo.data.DataRecordRepository
import kotlinx.coroutines.launch

private const val TAG = "DataRecordViewModel "

class DataRecordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DataRecordRepository
    val allItems: LiveData<List<DataRecord>>

    init {
        Log.d(TAG, "Inside ViewModel init")
        val dao = AppRoomDatabase.getDatabase(application).datarecordDao()
        repository = DataRecordRepository(dao)
        allItems = repository.allItems
    }

    fun insert(item: DataRecord) = viewModelScope.launch {
        repository.insert(item)
    }

    fun update(item: DataRecord) = viewModelScope.launch {
        repository.update(item)
    }

    fun delete(item: DataRecord) = viewModelScope.launch {
        repository.delete(item)
    }

    fun get(id: Long) = repository.get(id)
}