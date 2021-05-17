package com.android.myapp

import adapters.DataAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import repositories.DataRepository
import retrofit2.Retrofit
import viewmodel.DataViewModel
import viewmodel.DataViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var dataViewModel: DataViewModel
    private val dataInterface = DataInterface.getInstance()
    val rvAdapter = DataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataViewModel =
            ViewModelProvider(this, DataViewModelFactory(DataRepository(dataInterface))).get(
                DataViewModel::class.java
            )

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.hasFixedSize()
        rv.layoutManager = LinearLayoutManager(this)
        rv.setAdapter(rvAdapter);
        rv.setNestedScrollingEnabled(true);

        dataViewModel.data.observe(this, Observer {
            rvAdapter.updateList(it)
        })

        dataViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }

    override fun onResume() {
        super.onResume()
        dataViewModel.getData()
    }
}