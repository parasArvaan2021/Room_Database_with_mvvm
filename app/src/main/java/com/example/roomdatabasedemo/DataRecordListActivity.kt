package com.example.roomdatabasedemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabasedemo.adapters.DataRecordAdapter
import com.example.roomdatabasedemo.viewmodels.DataRecordViewModel
import kotlinx.android.synthetic.main.activity_datarecord_list.*
import kotlinx.android.synthetic.main.data_record_list_recyclerview.*

private const val TAG = "DataRecordListActivity"  // TAG for Logs, if the need them

class DataRecordListActivity : AppCompatActivity() {

    private lateinit var datarecordViewModel: DataRecordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the layout
        setContentView(R.layout.activity_datarecord_list)
        setSupportActionBar(toolbar)

        // Set an action for the FAB: in particular, this will start a new activity
        fab_add.setOnClickListener { _ ->
            val intent = Intent(this, DataRecordDetail::class.java)
            startActivity(intent)
        }

        val recyclerView = datarecord_list
        val adapter = DataRecordAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        datarecordViewModel = ViewModelProvider(this).get(DataRecordViewModel::class.java)

        datarecordViewModel.allItems.observe(this, Observer { items ->
            items?.let { adapter.setItems(it) }
        })
    }
}
