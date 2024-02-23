package com.rodrigocsa.barbershop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.rodrigocsa.barbershop.R
import com.rodrigocsa.barbershop.adapter.ServicesAdapter
import com.rodrigocsa.barbershop.databinding.ActivityHomeBinding
import com.rodrigocsa.barbershop.model.Services

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicesAdapter: ServicesAdapter

    private val serviceList: MutableList<Services> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val name = intent.extras?.getString("name")
        binding.tvUsername.text = "Bem-vindo(a), $name"

        val recyclerServices = binding.rvRecyclerServices
        recyclerServices.layoutManager = GridLayoutManager(this, 2)
        servicesAdapter = ServicesAdapter(this, serviceList)
        recyclerServices.setHasFixedSize(true)
        recyclerServices.adapter = servicesAdapter
        getServices()

        binding.btnToSchedule.setOnClickListener {
            val intent = Intent(this, Schedule::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

    }

    private fun getServices() {
        val service1 = Services(R.drawable.img1, getString(R.string.cutting_hair_text))
        serviceList.add(service1)

        val service2 = Services(R.drawable.img2, getString(R.string.coutting_beard_text))
        serviceList.add(service2)

        val service3 = Services(R.drawable.img3, getString(R.string.hair_washing_text))
        serviceList.add(service3)

        val service4 = Services(R.drawable.img4, getString(R.string.hair_treatment_text))
        serviceList.add(service4)
    }

}