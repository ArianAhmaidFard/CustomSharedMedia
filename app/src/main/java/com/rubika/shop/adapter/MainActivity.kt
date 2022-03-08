package com.rubika.shop.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubika.shop.adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var customAdapter: MyCustomAdapter
    private
    val response = listOf<ImageModel>(
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika),
        ImageModel(R.drawable.rubika)

    )
    private val finalList = mutableListOf<RowItems>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //write code here

        Constants.SCREEN_WIDTH = getScreenWidth()
        val iterator = response.size/Constants.COLUMNS_VALUE //  16/3 =5
        val modeResponse = response.size % Constants.COLUMNS_VALUE //16 % 3=1
        for(i in 0 until iterator) //5
        {
            finalList.add(RowItems(response.subList(i * Constants.COLUMNS_VALUE, (i * Constants.COLUMNS_VALUE) + Constants.COLUMNS_VALUE)))
        }
        finalList.add(RowItems(response.subList(response.lastIndex + 1 - modeResponse, response.lastIndex + 1)))
        setupAdapter()




    }
    private fun getScreenWidth():Int
    {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
    private fun setupAdapter() {
        customAdapter = MyCustomAdapter(finalList)
        layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerview.layoutManager =layoutManager
        binding.recyclerview.adapter = customAdapter

    }
}