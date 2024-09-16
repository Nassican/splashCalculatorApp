package com.nassican.splashcalculatorapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nassican.splashcalculatorapp.R
import com.nassican.splashcalculatorapp.database.model.IMCRecord

class IMCHistoryAdapter(private val imcRecords: List<IMCRecord>) :
    RecyclerView.Adapter<IMCHistoryAdapter.IMCViewHolder>() {

    class IMCViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTimeTextView: TextView = itemView.findViewById(R.id.dateTimeTextView)
        val weightHeightTextView: TextView = itemView.findViewById(R.id.weightHeightTextView)
        val bmiTextView: TextView = itemView.findViewById(R.id.bmiTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IMCViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_imc_record, parent, false)
        return IMCViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IMCViewHolder, position: Int) {
        val currentItem = imcRecords[position]
        holder.dateTimeTextView.text = "${currentItem.date} ${currentItem.time}"
        holder.weightHeightTextView.text = "Weight: ${currentItem.weight} kg, Height: ${currentItem.height} m"
        holder.bmiTextView.text = "BMI: %.2f".format(currentItem.bmi)
    }

    override fun getItemCount() = imcRecords.size
}