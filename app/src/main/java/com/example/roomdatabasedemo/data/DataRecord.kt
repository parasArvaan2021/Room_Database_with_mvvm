 package com.example.roomdatabasedemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datarecords")
data class DataRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val record: String
)

