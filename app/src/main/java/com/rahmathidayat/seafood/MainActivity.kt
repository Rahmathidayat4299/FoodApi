package com.rahmathidayat.seafood

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rahmathidayat.post.MainVM
import com.rahmathidayat.post.Repository
import com.rahmathidayat.post.Retrofit
import com.rahmathidayat.post.ViewModelFactory
import com.rahmathidayat.seafood.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainVM::class.java]
        viewModel.getPost()
        viewModel.dataPost.observe(this) { response ->
           if (response.isSuccessful){

               Log.d("Response", response.body()?.userId.toString())
               Log.d("Response", response.body()?.id.toString())
               Log.d("Response", response.body()?.title!!)
               binding.tvApi.text = response.body()?.title!!
               Log.d("Response", response.body()?.body!!)
           }
        }


    }
}