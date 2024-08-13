package com.example.myweather

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.myweather.databinding.FragmentItemBinding


class MyDailyForecastsRecyclerViewAdapter(
    private val values: ArrayList<DailyForecasts>
) : RecyclerView.Adapter<MyDailyForecastsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.date.text = item.Date?.substring(0, 10)
        holder.minimum.text = item.Temperature?.Minimum?.Value.toString()
        holder.maximum.text = item.Temperature?.Maximum?.Value.toString()

        val minDrawable = holder.itemView.context.getDrawable(R.drawable.min_temperature)
        holder.minImage.setImageDrawable(minDrawable)

        val maxDrawable = holder.itemView.context.getDrawable(R.drawable.max_temperature)
        holder.maxImage.setImageDrawable(maxDrawable)


    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val date: TextView = binding.tvDate
        val minimum: TextView = binding.tvMin
        val maximum: TextView = binding.tvMax

        val minImage: ImageView = binding.ivMin
        val maxImage: ImageView = binding.ivMax
        override fun toString(): String {
            return super.toString() + " '" + date.text + "'"
        }
    }
}
