package com.example.drinksdemo.network

import com.example.drinksdemo.model.Drink
import retrofit2.Response
import retrofit2.http.GET



interface RetrofitService {


    @GET(APIEndPoints.API_DRINKS_LIST)
    suspend fun getDrinkListService(): Response <Drink>

}

