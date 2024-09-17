package com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.razonkumar_dipti_ict_amad_l4_04_02_carapplication.databinding.DetailsActivityBinding

class DetailsActivity: AppCompatActivity() {
    private lateinit var binding: DetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DetailsActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        val model = intent.getStringExtra("Model")
        val price = intent.getStringExtra("Price")
        val img = intent.getIntExtra("Image",0)

        binding.apply {
            nameId.text = name
            modelId.text = model
            priceId.text = price
            image.setImageResource(img)

        }
    }
}