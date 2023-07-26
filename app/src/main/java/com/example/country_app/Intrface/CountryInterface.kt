package com.example.country_app.Intrface

import com.example.country_app.Model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface CountryInterface {

    @GET("all")
    fun getCountry() : Call<List<CountryModel>>
}