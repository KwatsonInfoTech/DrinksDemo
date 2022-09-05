package com.example.drinksdemo.repository

import com.example.drinksdemo.network.RetrofitService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class mainRepository @Inject constructor(private val RetrofitService: RetrofitService){

    suspend fun getAllDrinksFromAPI() = RetrofitService.getDrinkListService()


}