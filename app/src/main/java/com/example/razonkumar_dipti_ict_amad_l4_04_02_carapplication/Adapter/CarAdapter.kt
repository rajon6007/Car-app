package com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.Model.Car
import com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.databinding.ItemListBinding

class CarAdapter(private val carList: ArrayList<Car>):RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    var onClick: ((Car) -> Unit)? = null
    class CarViewHolder(val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
       return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.binding.apply {
            nameId.text = carList[position].carName
            modelId.text = carList[position].carModel
            priceId.text = carList[position].carPrice
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(carList[position])
        }
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Car")
                .setMessage("Are you sure you want to delete this car?")
                .setPositiveButton("Yes") { _, _ ->
                    carList.removeAt(position)
                    notifyDataSetChanged()
                }
                .setNegativeButton("No") { _, _ -> }
                .show()
            true


        }

    }
}