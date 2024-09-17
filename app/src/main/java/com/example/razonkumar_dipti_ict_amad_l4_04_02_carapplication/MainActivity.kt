package com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.Adapter.CarAdapter
import com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.Model.Car

import com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.databinding.ActivityMainBinding


class MainActivity(swipeDirs: Int) : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarAdapter
    val car =ArrayList<Car>()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.RV.layoutManager = LinearLayoutManager(this)

        car.add(Car("Lambergini","sm120","500000",R.drawable.lambargini))
        car.add(Car("Abarth","sm120","500000",R.drawable.abarth))
        car.add(Car("Acura","sm120","500000",R.drawable.acura))
        car.add(Car("Alfa Romeo","sm120","500000",R.drawable.alfaromeo))
        car.add(Car("Audi","sm120","500000",R.drawable.audi))
        car.add(Car("Bentley","sm120","500000",R.drawable.bentley))
        car.add(Car("BMW","sm120","500000",R.drawable.bmw))
        car.add(Car("Dacia","sm120","500000",R.drawable.dacia))
        car.add(Car("Ferrari","sm120","500000",R.drawable.ferrari))
        car.add(Car("Honda","sm120","500000",R.drawable.honda))
        car.add(Car("Hummer","sm120","500000",R.drawable.hummer))
        car.add(Car("Hyundai","sm120","500000",R.drawable.hyundai))
        car.add(Car("Infinity","sm120","500000",R.drawable.infinity))
        car.add(Car("jeep","sm120","500000",R.drawable.jeep))
        car.add(Car("Landrover","sm120","500000",R.drawable.landrover))
        car.add(Car("Isuzu","sm120","500000",R.drawable.isuzu))
        car.add(Car("Isuzu","sm120","500000",R.drawable.isuzu))
        car.add(Car("Isuzu","sm120","500000",R.drawable.isuzu))

        adapter= CarAdapter(car)
        binding.RV.adapter=adapter

        adapter.onClick = {
            val intent = Intent(this,DetailsActivity::class.java)
            intent.putExtra("Name",it.carName)
            intent.putExtra("Model",it.carModel)
            intent.putExtra("Price",it.carPrice)
            intent.putExtra("Image",it.carImage)
            startActivity(intent)
        }
        binding.add.setOnClickListener {
            showCarAddDialog()
        }
        val itemTouchHelper =ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(
            0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                car.removeAt(viewHolder.adapterPosition)
                adapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        }

        )
        itemTouchHelper.attachToRecyclerView(binding.RV)

    }
    private fun showCarAddDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_car,null)
        val nameEt = dialogView.findViewById<EditText>(R.id.nameEt)
        val modelEt = dialogView.findViewById<EditText>(R.id.modelEt)
        val priceEt = dialogView.findViewById<EditText>(R.id.priceEt)

        AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name = nameEt.text.toString()
                val model = modelEt.text.toString()
                val price = priceEt.text.toString()
                val img = R.drawable.lambargini
                car.add(Car(name,model,price,img))
                adapter.notifyItemInserted(car.size-1)
            }
            .setNegativeButton("Cancel") { _, _ -> }
            .show()

    }
}


