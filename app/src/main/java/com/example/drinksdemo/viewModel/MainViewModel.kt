package com.example.drinksdemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.drinksdemo.model.Drink
import com.example.drinksdemo.repository.mainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: mainRepository) : ViewModel() {
    val errorMsg = MutableLiveData<String>()
    val respData = MutableLiveData<Drink>()
    var job: Job? =null

    fun getDrinkDataFromVM(){
        job = CoroutineScope(Dispatchers.IO).launch {

            val response = repository.getAllDrinksFromAPI()
            withContext(Dispatchers.Main){
                respData.postValue(response.body())

            }


        }



    }

}