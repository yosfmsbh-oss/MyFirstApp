package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.servicesRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val services = listOf(
            android.R.drawable.ic_menu_mapmode,
            android.R.drawable.ic_menu_myplaces,
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_lock_idle_lock
        )

        recyclerView.adapter = ServicesAdapter(services)
    }

    class ServicesAdapter(private val icons: List<Int>) :
        RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val icon: ImageView = view.findViewById(R.id.serviceIcon)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_service, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.icon.setImageResource(icons[position])
        }

        override fun getItemCount() = icons.size
    }
}
