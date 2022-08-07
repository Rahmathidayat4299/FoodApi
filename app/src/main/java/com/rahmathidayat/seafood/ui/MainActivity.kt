package com.rahmathidayat.seafood.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahmathidayat.post.MainVM
import com.rahmathidayat.post.Repository
import com.rahmathidayat.post.ViewModelFactory
import com.rahmathidayat.seafood.AdapterFood
import com.rahmathidayat.seafood.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainVM
    private lateinit var adapterFood : AdapterFood

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainVM::class.java]
        adapterFood = AdapterFood()
        binding.recyclerView.apply {
            adapter = adapterFood
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        }

        viewModel.listSeaFood("seafood").observe(this){
            if (it != null){
                adapterFood.differ.submitList(it)
            }
        }



    }
}