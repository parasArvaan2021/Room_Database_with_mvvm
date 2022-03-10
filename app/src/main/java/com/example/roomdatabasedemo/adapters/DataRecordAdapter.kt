 package com.example.roomdatabasedemo.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.Constants
import com.example.roomdatabasedemo.DataRecordDetail
import com.example.roomdatabasedemo.R
import com.example.roomdatabasedemo.data.DataRecord

private const val TAG = "DataRecordAdapter"

class DataRecordAdapter internal constructor(context: Context) :

    RecyclerView.Adapter<DataRecordAdapter.DataRecordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itemsList = emptyList<DataRecord>().toMutableList()

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as DataRecord

            Log.d(TAG, "Setting onClickListener for item ${item.id}")

            val intent = Intent(v.context, DataRecordDetail::class.java).apply {
                putExtra(Constants.DATA_RECORD_ID, item.id)
            }
            v.context.startActivity(intent)
        }
    }

    inner class DataRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemId: TextView = itemView.findViewById(R.id.datarecord_viewholder_id)
        val itemRecord: TextView = itemView.findViewById(R.id.datarecord_viewholder_record)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataRecordViewHolder {
        val itemView = inflater.inflate(R.layout.datarecord_viewholder, parent, false)
        return DataRecordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataRecordViewHolder, position: Int) {
        val current = itemsList[position]

        // Needed: will be referenced in the View.OnClickListener above
        holder.itemView.tag = current

        with(holder) {
            // Set UI values
            itemId.text = current.id.toString()
            itemRecord.text = current.record

            // Set handlers
            itemView.setOnClickListener(onClickListener)
        }
    }

    internal fun setItems(items: List<DataRecord>) {
        this.itemsList = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount() = itemsList.size
}