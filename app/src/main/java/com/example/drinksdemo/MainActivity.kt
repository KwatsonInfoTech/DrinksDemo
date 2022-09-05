package com.example.drinksdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drinksdemo.adapter.DrinkAdapter
import com.example.drinksdemo.databinding.ActivityMainBinding
import com.example.drinksdemo.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private  lateinit var activityBinding: ActivityMainBinding
    private val drinkAdapter = DrinkAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        //adapter and layout
        activityBinding.recyclerView.adapter = drinkAdapter
        activityBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        callService()
       getDataToDisplay()

    }

    fun callService(){

        viewModel.getDrinkDataFromVM()

    }

    fun getDataToDisplay(){
        // the UI will request live data and not VM
        // VM observes changes in live data

        viewModel.respData.observe(this){
            //Log.i("Drink",it.strDrink)
            drinkAdapter.submitList(this.drinkAdapter.currentList)

        }


    }



}